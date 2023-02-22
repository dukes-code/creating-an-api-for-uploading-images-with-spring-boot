package com.dukescode.filemanager.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.dukescode.filemanager.response.FileResponse;
import com.dukescode.filemanager.response.MessageResponse;
import com.dukescode.filemanager.service.FileService;
import com.dukescode.filemanager.model.FileEntity;

@Controller
@CrossOrigin("http://localhost:8001")
public class FileController {

  @Autowired
  private FileService fileService;

  @PostMapping("/upload")
  public ResponseEntity<MessageResponse> uploadFile(@RequestParam("file") MultipartFile file) {

    String message = "";

    try {
      fileService.store(file);

      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));

    } catch (Exception e) {

      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));

    }
  }

  @GetMapping("/files")
  public ResponseEntity<List<FileResponse>> getListFiles() {

    List<FileResponse> files = fileService.getAllFiles().map(fileFromDatabase -> {

      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(fileFromDatabase.getId())
          .toUriString();

      return new FileResponse(
          fileFromDatabase.getName(),
          fileDownloadUri,
          fileFromDatabase.getContentType(),
          fileFromDatabase.getData().length);

    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable String id) throws FileNotFoundException {
    
    FileEntity fileFromDatabase = fileService.getFile(id);

    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileFromDatabase.getName() + "\"")
        .body(fileFromDatabase.getData());
  }
  
}
