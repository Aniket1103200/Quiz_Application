package com.quiz.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.quiz.exception.customException.QuizApplicationException;
import com.quiz.exception.customException.ResourceNotFoundException;
import com.quiz.util.ApiResponse;
import com.quiz.util.ResponseUtils;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<String>> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        ApiResponse<String> apiResponse = ResponseUtils.createErrorResponse("Resource Not Found: " + ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    // Handle QuizApplicationException
    @ExceptionHandler(QuizApplicationException.class)
    public ResponseEntity<ApiResponse<String>> handleQuizApplicationException(QuizApplicationException ex, WebRequest request) {
        ApiResponse<String> apiResponse = ResponseUtils.createErrorResponse("Application Error: " + ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    // Handle RuntimeException
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<String>> handleRuntimeException(RuntimeException ex, WebRequest request) {
        ApiResponse<String> apiResponse = ResponseUtils.createErrorResponse("Internal Server Error: " + ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Handle other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGlobalException(Exception ex, WebRequest request) {
        ApiResponse<String> apiResponse = ResponseUtils.createErrorResponse("An error occurred: " + ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}