package com.novi.easyboat.controllers;

import com.novi.easyboat.controllers.dto.IdInputDto;
import com.novi.easyboat.controllers.dto.SkipperDto;
import com.novi.easyboat.controllers.dto.SkipperInputDto;
import com.novi.easyboat.exceptions.BadRequestException;
import com.novi.easyboat.model.Skipper;
import com.novi.easyboat.services.SkipperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("skippers")
public class SkipperController {
    private final SkipperService skipperService;

    @Autowired
    public SkipperController(SkipperService skipperService) {
        this.skipperService = skipperService;
    }

    @GetMapping
    public List<SkipperDto> getSkippers() {
        var dtos = new ArrayList<SkipperDto>();
        var skippers = skipperService.getSkippers();

        for (Skipper skipper : skippers) {
            dtos.add(SkipperDto.fromSkipper(skipper));
        }

        return dtos;
    }

    @GetMapping("/{id}")
    public SkipperDto getSkipper(@PathVariable("id") Long id) {
        var skipper = skipperService.getSkipper(id);
        return SkipperDto.fromSkipper(skipper);
    }

    @PostMapping
    public SkipperDto saveSkipper(@RequestBody SkipperInputDto dto) {
        var skipper = skipperService.saveSkipper(dto.toSkipper());
        return SkipperDto.fromSkipper(skipper);
    }

    @DeleteMapping("/{id}")
    public void deleteSkipper(@PathVariable("id") Long id) {
        skipperService.deleteSkipper(id);
    }

    @PostMapping("/{id}/license")
    public void uploadLicense(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file) throws IOException {
        if (file.getContentType() == null || !file.getContentType().equals("application/pdf")) {
            throw new BadRequestException();
        }
        skipperService.uploadLicense(id, file);
    }

    @GetMapping("/{id}/license")
    public ResponseEntity<byte[]> getLicense(@PathVariable("id") Long id) {
        var licenseBytes = skipperService.getLicense(id);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"license.pdf\"")
                .body(licenseBytes);
    }

    @PostMapping("/{id}/boat")
    public void assignBoatToSkipper(@PathVariable("id") Long skipperId, @RequestBody IdInputDto input) {
        skipperService.assignBoat(skipperId, input.id);
    }
}
