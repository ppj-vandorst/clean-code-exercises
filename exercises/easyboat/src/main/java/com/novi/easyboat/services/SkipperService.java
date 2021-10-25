package com.novi.easyboat.services;

import com.novi.easyboat.model.Skipper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SkipperService {
    List<Skipper> getSkippers();

    Skipper getSkipper(Long id);

    Skipper saveSkipper(Skipper skipper);

    void deleteSkipper(Long id);

    void assignBoat(Long skipperId, Long BoatId);

    void uploadLicense(Long id, MultipartFile file) throws IOException;

    byte[] getLicense(Long id);
}
