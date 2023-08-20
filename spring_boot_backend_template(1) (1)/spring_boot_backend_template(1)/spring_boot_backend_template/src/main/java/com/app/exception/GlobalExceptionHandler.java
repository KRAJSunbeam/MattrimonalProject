package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.app.custexception.ResourceNotFoundException;
import com.app.payload.ApiResponse;

public class GlobalExceptionHandler {
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e) {
		return ResponseEntity.
				status(HttpStatus.NOT_FOUND).
				body(new ApiResponse(e.getMessage()));
	}
}
