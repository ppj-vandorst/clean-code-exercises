package com.novi.easyboat.controllers.dto;

import com.novi.easyboat.model.Skipper;

public class SkipperInputDto {
    public String firstname;
    public String lastname;
    public String phoneNumber;

    public Skipper toSkipper() {
        var skipper = new Skipper();
        skipper.setFirstname(firstname);
        skipper.setLastname(lastname);
        skipper.setPhoneNumber(phoneNumber);
        return skipper;
    }
}
