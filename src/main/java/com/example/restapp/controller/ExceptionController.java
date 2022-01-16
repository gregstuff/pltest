package com.example.restapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Component
public class ExceptionController {

	@ExceptionHandler
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<String>> handle(
			ConstraintViolationException exception) {
		List<String> errorMessageList = exception.getConstraintViolations()
				.stream().map(violation -> violation.getMessage())
				.collect(Collectors.toList());
		return ResponseEntity.ok(errorMessageList);
	}

}
