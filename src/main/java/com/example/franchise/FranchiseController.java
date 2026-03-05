package com.example.franchise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/franchises")
// CRITICAL: This allows your React app on port 5173 to access this controller
@CrossOrigin(origins = "http://localhost:5173") 
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
        f.setId(id);
        return repo.save(f);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { 
        repo.deleteById(id); 
    }
}