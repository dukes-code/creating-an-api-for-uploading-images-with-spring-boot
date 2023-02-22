package com.dukescode.filemanager.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class FileResponse {
    
    private final String name;
    private final String url;
    private final String type;
    private final long size;
  }
