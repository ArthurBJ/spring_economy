package group907.baybikov.springwitch.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class ImageController {

    @Value("${image.path}")
    private String uploadDir;

    @Value("${image.service.path}")
    private String serviceDir;

    @GetMapping(value = "/get/image/{name}" ,produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable String name) throws IOException {
        InputStream in = new FileInputStream(uploadDir + File.separator + name);

        byte[] byteImage = new byte[in.available()];
        in.read(byteImage);
        return byteImage;
    }

    @GetMapping(value = "/get/services/{name}" ,produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImageService(@PathVariable String name) throws IOException {
        InputStream in = new FileInputStream(serviceDir + File.separator + name);

        byte[] byteImage = new byte[in.available()];
        in.read(byteImage);
        return byteImage;
    }

}
