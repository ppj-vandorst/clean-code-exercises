package com.novi.easyboat.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shout")
public class ShoutController {

    @PostMapping
    public String shout(@RequestBody String input) {
        return input.toUpperCase() + "!!!";
    }
}
