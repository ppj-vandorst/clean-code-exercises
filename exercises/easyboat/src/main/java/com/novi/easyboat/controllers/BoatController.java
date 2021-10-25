package com.novi.easyboat.controllers;

import com.novi.easyboat.controllers.dto.BoatDto;
import com.novi.easyboat.controllers.dto.BoatInputDto;
import com.novi.easyboat.model.Boat;
import com.novi.easyboat.services.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("boats")
public class BoatController {
    private final BoatService boatService;

    @Autowired
    public BoatController(BoatService boatService) {
        this.boatService = boatService;
    }

    @GetMapping
    public List<BoatDto> getBoats(@RequestParam(value = "query", required = false, defaultValue = "") String query,
                                  @RequestParam(value = "type", required = false) String type) {
        var dtos = new ArrayList<BoatDto>();

        List<Boat> boats;
        if (type == null) {
            boats = boatService.findBoatsByName(query);
        } else {
            boats = boatService.findBoatsByType(type);
        }

        for (Boat boat : boats) {
            dtos.add(BoatDto.fromBoat(boat));
        }

        return dtos;
    }

    @PostMapping
    public BoatDto saveBoat(@RequestBody BoatInputDto dto) {
        var boat = boatService.saveBoat(dto.toBoat());
        return BoatDto.fromBoat(boat);
    }

    @DeleteMapping("/{id}")
    public void deleteBoat(@PathVariable("id") Long id) {
        boatService.deleteBoat(id);
    }
}
