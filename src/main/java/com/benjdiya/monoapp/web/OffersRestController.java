package com.benjdiya.monoapp.web;

import com.benjdiya.monoapp.dtos.OffresDTO;
import com.benjdiya.monoapp.entities.Offres;
import com.benjdiya.monoapp.service.OffersService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
@RestController
public class OffersRestController {
@Autowired
private OffersService offersService;

    @Value("${image.upload.dir}")
    private String uploadDir;

    @GetMapping("/listoffres")
    public List<OffresDTO> offerlist() {
        return offersService.OFFRES_DTO_LIST();
    }

    @PostMapping("/offer")
    public void offre(@RequestBody OffresDTO offre){
        offersService.offre(offre);
    }

    @GetMapping("/img/{filename}")
    public ResponseEntity<Resource> getImage(@PathVariable("filename") String filename) {
        try {
            Path filePath = Paths.get(uploadDir).resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (!resource.exists()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG) // ou autre type si nécessaire
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);

        } catch (MalformedURLException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
