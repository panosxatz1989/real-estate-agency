package demo.pxportfolio.realestateagency.config.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler({
            AttachmentCreationException.class
    })
    public ResponseEntity<ApiError> handleAttachmentCreationException(AttachmentCreationException ex) {
        ApiError error = new ApiError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                ErrorType.FILE_UPLOAD_ERROR,
                ex.getLocalizedMessage(),
                new ArrayList<>()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex) {
        List<ApiFieldError> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(this::convertFieldErrors)
                .toList();

        ApiError error = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                ErrorType.VALIDATION_FAIL,
                ex.getLocalizedMessage(),
                errors
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    public ApiFieldError convertFieldErrors(ObjectError error) {
        if (error == null) return ApiFieldError.builder().build();

        String fieldName = ((FieldError) error).getField();
        String errorMessage = error.getDefaultMessage();

        return ApiFieldError.builder()
                .fieldName(fieldName)
                .message(errorMessage)
                .build();
    }
}
