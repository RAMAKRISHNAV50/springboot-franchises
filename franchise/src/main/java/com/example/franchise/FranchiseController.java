package com.example.franchise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/franchises")
// Allows your React app on Port 5173 to communicate with this Backend
@CrossOrigin(origins = "http://localhost:5173") 
public class FranchiseController {

    @Autowired  
    private FranchiseRepository repo;

    // CREATE: Used by Fsignup.jsx
    @PostMapping
    public Franchise create(@RequestBody Franchise f) { 
        // Logic check: Ensure networth is handled as a Double
        System.out.println("Registering Team: " + f.getFranchiseName());
        return repo.save(f); 
    }

    // READ ALL: Used by FranchiseLogin.jsx to verify credentials
    @GetMapping
    public List<Franchise> getAll() {
        return repo.findAll();
    }

    // READ ONE: Used for individual Dashboard data
    @GetMapping("/{id}")
    public Franchise getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // UPDATE: Used to deduct budget after buying a player
    @PutMapping("/{id}")
    public Franchise update(@PathVariable Long id, @RequestBody Franchise f) {
        f.setId(id);
        return repo.save(f);
    }

    // DELETE: For removing a franchise
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}