package com.adarsh.Booking_Service.ExceptionHandling;

import com.adarsh.Booking_Service.ExceptionHandling.Exceptions.NoDataPresentInDb;
import com.adarsh.Booking_Service.ExceptionHandling.Exceptions.SareeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(SareeNotFoundException.class)
    public ResponseEntity<String> handleListIsEmptyException(SareeNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }


    @ExceptionHandler(NoDataPresentInDb.class)
    public ResponseEntity<String> handleNoDataPresentInDbException(NoDataPresentInDb e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
