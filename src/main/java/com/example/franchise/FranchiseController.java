package com.example.franchise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController 
@RequestMapping("/franchises")
// FIX: Using originPatterns to avoid the "allowCredentials" security conflict
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