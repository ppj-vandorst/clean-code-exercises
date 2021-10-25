package com.novi.easyboat.repositories;

import com.novi.easyboat.model.Boat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoatRepository extends JpaRepository<Boat, Long> {
    List<Boat> findByNameContainingIgnoreCase(String query);

    List<Boat> findByType(String type);
}
