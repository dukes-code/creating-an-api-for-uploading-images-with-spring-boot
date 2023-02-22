package com.dukescode.filemanager.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.dukescode.filemanager.model.FileEntity;
import com.dukescode.filemanager.repository.FileRepository;

@Service
public class FileService {

  @Autowired
  private FileRepository fileRepository;

  public FileEntity store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileEntity fileEntity = new FileEntity(fileName, file.getContentType(), file.getSize(), file.getBytes());

    return fileRepository.save(fileEntity);
  }

  public FileEntity getFile(String id) throws FileNotFoundException {
    return fileRepository.findById(id).orElseThrow(() -> new FileNotFoundException("File not found with id: " + id));
  }
  
  public Stream<FileEntity> getAllFiles() {
    return fileRepository.findAll().stream();
  }
}
