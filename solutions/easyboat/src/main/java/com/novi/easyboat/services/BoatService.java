package com.novi.easyboat.services;

import com.novi.easyboat.model.Boat;

import java.util.List;

public interface BoatService {
    List<Boat> getBoats();

    List<Boat> findBoatsByName(String query);

    List<Boat> findBoatsByType(String type);

    Boat saveBoat(Boat boat);

    void deleteBoat(Long id);
}
