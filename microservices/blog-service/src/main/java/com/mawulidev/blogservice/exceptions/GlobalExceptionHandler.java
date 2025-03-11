package com.mawulidev.blogservice.exceptions;

import com.mawulidev.blogservice.dto.ResponseHandler;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NotNull MethodArgumentNotValidException ex,
                                                                  @NotNull HttpHeaders headers,
                                                                  @NotNull HttpStatusCode status,
                                                                  @NotNull WebRequest request) {
        List<ErrorResponse> errorResponse = ex.getAllErrors()
                .stream()
                .map(violations ->
                        new ErrorResponse(LocalDateTime.now(), violations.getDefaultMessage(), request.getDescription(false))
                ).toList();

        return ResponseHandler.errorResponse(HttpStatus.BAD_REQUEST, errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handlerAllExceptions(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return ResponseHandler.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR, List.of(errorResponse));
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<Object> handlerEntityNotFoundExceptions(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return ResponseHandler.errorResponse(HttpStatus.NOT_FOUND, List.of(errorResponse));
    }
//
//    @ExceptionHandler({ BadCredentialsException.class})
//    public final ResponseEntity<Object> handlerBadRequest(Exception ex, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
//        return ResponseHandler.errorResponse(HttpStatus.BAD_REQUEST, List.of(errorResponse));
//    }
//
//    @ExceptionHandler({SignatureException.class, InsufficientAuthenticationException.class})
//    public final ResponseEntity<Object> handlerSecurityExceptions(Exception ex, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
//        return ResponseHandler.errorResponse(HttpStatus.UNAUTHORIZED, List.of(errorResponse));
//    }
//    @ExceptionHandler({AccessDeniedException.class})
//    public final ResponseEntity<Object> handlerSecurityAccessExceptions(Exception ex, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
//        return ResponseHandler.errorResponse(HttpStatus.FORBIDDEN, List.of(errorResponse));
//    }




}
