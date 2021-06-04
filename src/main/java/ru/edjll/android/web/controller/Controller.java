package ru.edjll.android.web.controller;

import org.postgresql.util.Base64;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.edjll.android.web.entity.Image;
import ru.edjll.android.web.service.ImageService;

@RestController
public class Controller {

    private final ImageService imageService;

    public Controller(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/save")
    public Long save(@RequestBody Image image) {
        return imageService.save(image);
    }

    @GetMapping("/{id}/base64")
    public String getBase64(@PathVariable Long id) {
        return imageService.findById(id).getImageBase64();
    }

    @GetMapping(value = "/{id}/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable Long id) {
        return Base64.decode(imageService.findById(id).getImageBase64());
    }
}
