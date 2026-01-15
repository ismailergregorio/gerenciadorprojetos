package com.example.API_Fabrica_Software.Exception;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
 @ExceptionHandler(Exception.class)
 public ResponseEntity<ApiError> handleGeral(Exception ex, HttpServletRequest request) {
  ApiError erro = new ApiError(LocalDateTime.now(),
    500,
    "Erro interno",
    "Erro inesperrado no servidor",
    request.getRequestURI());
  return ResponseEntity.status(500).body(erro);
 }

 @ExceptionHandler(DataIntegrityViolationException.class)
 public ResponseEntity<ApiError> itemJaExite(Exception ex, HttpServletRequest request) {
  ApiError erro = new ApiError(LocalDateTime.now(),
    409,
    "Erro Conflito",
    "Erro Iten Ja existe no banco de dados",
    request.getRequestURI());
  return ResponseEntity.status(409).body(erro);
 }
}
