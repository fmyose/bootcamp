package com.meli.obterdiploma.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.meli.obterdiploma.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class StudentExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDTO>> handleModelValidation(MethodArgumentNotValidException e) {

        List<ErrorDTO> errorDTOList = e.getBindingResult().getAllErrors().stream()
                .map(objectError -> new ErrorDTO("MethodArgumentNotValidException", objectError.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(errorDTOList, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<ErrorDTO> handleHttpMessageNotReadableEx(JsonParseException e) {
        ErrorDTO errorDTO = new ErrorDTO("handleHttpMessageNotReadableEx", e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
