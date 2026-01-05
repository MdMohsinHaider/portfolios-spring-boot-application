package com.mohsin.portfolio.controller;

import com.mohsin.portfolio.entity.PortfolioItem;
import com.mohsin.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin(origins = "*")
public class PortfolioController {

    @Autowired
    private PortfolioService service;

    @GetMapping
    public ResponseEntity<List<PortfolioItem>> getAll() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PortfolioItem> getById(@PathVariable Long id) {
        PortfolioItem item = service.getItemById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PortfolioItem> create(@RequestBody PortfolioItem item) {
        return ResponseEntity.ok(service.saveItem(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PortfolioItem> update(@PathVariable Long id, @RequestBody PortfolioItem item) {
        item.setId(id);
        return ResponseEntity.ok(service.saveItem(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteItem(id);
        return ResponseEntity.ok().build();
    }
}
