package com.novi.easyboat.controllers.dto;

import com.novi.easyboat.model.Skipper;

public class SkipperDto {
    public Long id;
    public String firstname;
    public String lastname;
    public String phoneNumber;
    public BoatDto boat;

    public static SkipperDto fromSkipper(Skipper skipper) {
        var dto = new SkipperDto();
        dto.id = skipper.getId();
        dto.firstname = skipper.getFirstname();
        dto.lastname = skipper.getLastname();
        dto.phoneNumber = skipper.getPhoneNumber();
        dto.boat = BoatDto.fromBoat(skipper.getBoat());
        return dto;
    }
}
