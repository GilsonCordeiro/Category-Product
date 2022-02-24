package com.books.Test.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;


    @ControllerAdvice
    public class ProductHandleException extends ResponseEntityExceptionHandler {
        @Autowired
        private MessageSource messageSource;

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            List<Erro> erros = criarListErros(ex.getBindingResult());
            return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
        }

        private List<Erro> criarListErros(BindingResult bindingResult) {
            List<Erro> erros = new ArrayList<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                String messagem = fieldError.getDefaultMessage();
                erros.add(new Erro(messagem));
            }
            return erros;

        }

        public class Erro{
            String messagem;

            public Erro(String messagem){
                this.messagem = messagem;
            }

            public String getMessagem() {
                return messagem;
            }

            public void setMessagem(String messagem) {
                this.messagem = messagem;
            }
        }
}
