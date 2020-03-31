import { Injectable } from '@angular/core';
import { Spending } from './spending';
import { AuthService } from './auth.service'
import { HttpHeaders, HttpClient } from '@angular/common/http';

export const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Authorization': ''
  })
};

@Injectable({
  providedIn: 'root'
})
export class SpendingService {
  public spending: Spending;
  public redirectUrl: string;

  private spendingUrl: string = 'http://localhost:8080/spendings/create'

  constructor(
    private http: HttpClient,
    private authService: AuthService
  ) {
    httpOptions.headers = httpOptions.headers.set('Authorization', `Basic ${authService.getToken()}`);
  }

  createSpending(spending: Spending): Promise<Spending> {
    return this.http.post<Spending>(`${this.spendingUrl}`, spending, httpOptions).toPromise();
  }
}