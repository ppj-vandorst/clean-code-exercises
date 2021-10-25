package com.novi.easyboat.services;

import com.novi.easyboat.model.Boat;
import com.novi.easyboat.repositories.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatServiceImpl implements BoatService {
    private BoatRepository repository;

    @Autowired
    public BoatServiceImpl(BoatRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Boat> getBoats() {
        return repository.findAll();
    }

    @Override
    public List<Boat> findBoatsByName(String query) {
        return repository.findByNameContainingIgnoreCase(query);
    }

    @Override
    public List<Boat> findBoatsByType(String type) {
        return repository.findByType(type);
    }

    @Override
    public Boat saveBoat(Boat boat) {
        return repository.save(boat);
    }

    @Override
    public void deleteBoat(Long id) {
        repository.deleteById(id);
    }


    public int add(int val1, int val2) {
        if(val1 > 10000) {
            throw new RuntimeException("error");
        }

        return val1 + val2;
    }
}
