package com.example.franchise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/franchises")
// UPDATED: Allows connections from any deployed frontend (Vercel, Netlify, or Local)
@CrossOrigin(origins = "*") 
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

    @PutMapping("/{id}")
    public Franchise update(@PathVariable Long id, @RequestBody Franchise f) {
        // Ensuring we update the existing record rather than creating a new one
        return repo.findById(id).map(existing -> {
            existing.setName(f.getName());
            existing.setBudget(f.getBudget());
            // Add any other fields your Franchise entity has here
            return repo.save(existing);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { 
        repo.deleteById(id); 
    }
}