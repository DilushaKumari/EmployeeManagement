package lk.ou.se.test.advice;

import lk.ou.se.test.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@CrossOrigin
@RestControllerAdvice
public class AppWideExceptionHandler {


    @ExceptionHandler({NotFoundException.class, EntityNotFoundException.class})
    public ResponseEntity handleNotFoundException(Exception e) {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
