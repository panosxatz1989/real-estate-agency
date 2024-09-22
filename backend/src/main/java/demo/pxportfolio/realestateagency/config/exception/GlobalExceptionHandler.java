package demo.pxportfolio.realestateagency.config.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            EntityNotFoundException.class
    })
    public ResponseEntity<ApiError> handleEntityNotFoundException(RuntimeException ex) {
        ApiError error = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                ErrorType.ENTITY_NOT_FOUND,
                ex.getLocalizedMessage(),
                new ArrayList<>()
        );

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
