package com.mohsin.portfolio.service;

import com.mohsin.portfolio.entity.PortfolioItem;
import com.mohsin.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository repository;

    public List<PortfolioItem> getAllItems() {
        return repository.findAll();
    }

    public PortfolioItem getItemById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public PortfolioItem saveItem(PortfolioItem item) {
        return repository.save(item);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}
