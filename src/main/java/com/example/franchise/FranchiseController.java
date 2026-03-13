package com.example.franchise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/franchises")
@CrossOrigin(originPatterns = "*")
public class FranchiseController {

    @Autowired
    private FranchiseRepository repo;

    @PostMapping
    public Franchise create(@RequestBody Franchise f) {
        return repo.save(f);
    }

    @GetMapping
    public List<Franchise> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Franchise getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // NEW: Get franchise details by name (used by React Dashboard)
    @GetMapping("/name/{name}")
    public Franchise getByName(@PathVariable String name) {
        return repo.findByFranchiseName(name).orElse(null);
    }

    // NEW: Specifically for deducting budget during Finalize Sale
    @PatchMapping("/{id}/deduct-budget")
    public void deductBudget(@PathVariable Long id, @RequestParam Double amount) {
        repo.findById(id).ifPresent(f -> {
            f.setNetworth(f.getNetworth() - amount);
            repo.save(f);
        });
    }

    // RESET: Reset all Franchise Networths to 1 Billion (100 Cr)
    @PostMapping("/reset-auction")
    public String resetAuction() {
        List<Franchise> franchises = repo.findAll();
        for (Franchise f : franchises) {
            f.setNetworth(1000000000.0);
            repo.save(f);
        }
        return "Auction has been reset successfully!";
    }

    @PutMapping("/{id}")
    public Franchise update(@PathVariable Long id, @RequestBody Franchise f) {
        return repo.findById(id).map(existing -> {
            existing.setName(f.getName());
            existing.setFranchiseName(f.getFranchiseName());
            existing.setOwnerName(f.getOwnerName());
            existing.setState(f.getState());
            existing.setNetworth(f.getNetworth()); 
            existing.setEmail(f.getEmail());
            existing.setPassword(f.getPassword());
            return repo.save(existing);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}