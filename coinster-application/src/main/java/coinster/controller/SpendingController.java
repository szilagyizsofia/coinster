package coinster.controller;

import coinster.model.*;
import coinster.repository.SpendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spendings")
public class SpendingController {

    @Autowired
    SpendingRepository spendingRepository;

    @GetMapping("/testcreateSpending")
    public String testcreateSpending(){
        spendingRepository.save(new Spending(new User("Rajesh01", "Bhojwani", Plan.regular, CurrencyUsed.USD), 100, true, SpendingCategory.bills));
        return "Customer created";
    }

    @PostMapping("/create")
    public String create(@RequestBody Spending spending) {
        spendingRepository.save(spending);
        return "Spending is created";
    }

    @GetMapping("/findall")
    public List<Spending> findAll() {
        return spendingRepository.findAll();
    }

    @GetMapping("/findByOwner/{owner}")
    public List<Spending> findByOwner(@PathVariable String owner) {
        return spendingRepository.findByOwner(owner);
    }

    @GetMapping("/findById/{id}")
    public Spending findById(@PathVariable int id) {
        return spendingRepository.findById(id);
    }
}
