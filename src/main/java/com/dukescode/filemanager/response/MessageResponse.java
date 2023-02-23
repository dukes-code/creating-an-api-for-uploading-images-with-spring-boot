package com.dukescode.filemanager.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class MessageResponse {

    private final String timestamp;
	private final Integer status;
    private final String message;
    private final String path;
	private final String method;
}
