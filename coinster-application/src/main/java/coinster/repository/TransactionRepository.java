package coinster.repository;

import coinster.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {

    @Autowired
    SpendingRepository spendingRepository;
    @Autowired
    IncomeRepository incomeRepository;

    public List<Transaction> findAll() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.addAll(spendingRepository.findAll());
        transactions.addAll(incomeRepository.findAll());
        return transactions;
    }

    public List<Transaction> findByOwner(final String owner) {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.addAll(spendingRepository.findByOwner(owner));
        transactions.addAll(incomeRepository.findByOwner(owner));
        return transactions;
    }
}