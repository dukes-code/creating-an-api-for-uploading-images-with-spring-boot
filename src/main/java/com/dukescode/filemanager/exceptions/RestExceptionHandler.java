package com.dukescode.filemanager.exceptions;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.dukescode.filemanager.response.MessageResponse;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final ZoneId BRAZIL_TIMEZONE = ZoneId.of("America/Sao_Paulo");

    @ExceptionHandler({MaxUploadSizeExceededException.class, IOException.class,
            FileNotFoundException.class})
    public ResponseEntity<MessageResponse> handleExceptions(Exception exception,
            HttpServletRequest request) {

        HttpStatus httpStatus;

        if (exception instanceof MaxUploadSizeExceededException) {
            httpStatus = HttpStatus.BAD_REQUEST;
        } else if (exception instanceof FileNotFoundException) {
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ResponseEntity.status(httpStatus)
                .body(new MessageResponse(LocalDateTime.now(BRAZIL_TIMEZONE).toString(),
                        httpStatus.value(), exception.getMessage(), request.getRequestURI(),
                        request.getMethod()));
    }
}
