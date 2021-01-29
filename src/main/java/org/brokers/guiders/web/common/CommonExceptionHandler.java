package org.brokers.guiders.web.common;

import lombok.extern.slf4j.Slf4j;
import org.brokers.guiders.exception.EssayNotFoundException;
import org.brokers.guiders.exception.MemberNotFoundException;
import org.brokers.guiders.exception.MentoringNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<?> handleMemberNotFoundException(MemberNotFoundException e) {
        log.error("MemberNotFoundException: ", e);
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EssayNotFoundException.class)
    public ResponseEntity<?> handleEssayNotFoundException(EssayNotFoundException e) {
        log.error("EssayNotFoundException: ", e);
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MentoringNotFoundException.class)
    public ResponseEntity<?> handleMentoringNotFoundException(MentoringNotFoundException e) {
        log.error("MentoringNotFoundException: ", e);
        return ResponseEntity.notFound().build();
    }
}
