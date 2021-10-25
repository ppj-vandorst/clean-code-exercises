package com.novi.easyboat.services;

import com.novi.easyboat.exceptions.NotFoundException;
import com.novi.easyboat.model.Skipper;
import com.novi.easyboat.repositories.BoatRepository;
import com.novi.easyboat.repositories.SkipperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SkipperServiceImpl implements SkipperService {
    private SkipperRepository skipperRepository;
    private BoatRepository boatRepository;

    @Autowired
    public SkipperServiceImpl(SkipperRepository skipperRepository, BoatRepository boatRepository) {
        this.skipperRepository = skipperRepository;
        this.boatRepository = boatRepository;
    }

    @Override
    public List<Skipper> getSkippers() {
        return skipperRepository.findAll();
    }

    @Override
    public Skipper getSkipper(Long id) {
        var optionalSkipper = skipperRepository.findById(id);
        if (optionalSkipper.isPresent()) {
            return optionalSkipper.get();
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public Skipper saveSkipper(Skipper skipper) {
        return skipperRepository.save(skipper);
    }

    @Override
    public void deleteSkipper(Long id) {
        skipperRepository.deleteById(id);
    }

    @Override
    public void assignBoat(Long skipperId, Long boatId) {
        var optionalSkipper = skipperRepository.findById(skipperId);
        var optionalBoat = boatRepository.findById(boatId);

        if (optionalSkipper.isPresent() && optionalBoat.isPresent()) {
            var skipper = optionalSkipper.get();
            var boat = optionalBoat.get();

            skipper.setBoat(boat);
            skipperRepository.save(skipper);
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public void uploadLicense(Long id, MultipartFile file) throws IOException {
        var optionalSkipper = skipperRepository.findById(id);
        if (optionalSkipper.isPresent()) {
            var skipper = optionalSkipper.get();
            skipper.setLicense(file.getBytes());
            skipperRepository.save(skipper);
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public byte[] getLicense(Long id) {
        var optionalSkipper = skipperRepository.findById(id);
        if (optionalSkipper.isPresent()) {
            return optionalSkipper.get().getLicense();
        } else {
            throw new NotFoundException();
        }
    }
}
