package com.fileUploadService.s3.Controller;

import com.fileUploadService.s3.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class FileUploadController {
    @Autowired
    public FileUploadService fileUploadService;
    @PostMapping
    public ResponseEntity<String> uploadFileToS3(@RequestParam("file")MultipartFile  multipartFile)
    {
        String fileUrl = fileUploadService.uploadToS3(multipartFile);
        return ResponseEntity.ok("File uploaded to: " + fileUrl);
    }
}
