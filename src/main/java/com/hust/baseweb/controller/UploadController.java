package com.hust.baseweb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("api/public/files")
public class UploadController {

    @Value("${file.upload.location}")
    private String location;

    @PostMapping
    public ResponseEntity<Object> upload( @RequestParam("files")MultipartFile[] files) throws Exception {
        Path folder = Paths.get(location);
        for (MultipartFile file : files) {
            // copy data  from multipart file -> new file
            Files.copy(file.getInputStream(), folder.resolve(file.getOriginalFilename()));
        }
        return ResponseEntity.noContent().build();
    }

}
