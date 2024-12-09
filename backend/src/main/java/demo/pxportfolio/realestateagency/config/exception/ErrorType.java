package demo.pxportfolio.realestateagency.config.exception;

import lombok.Getter;

@Getter
public enum ErrorType {

    ENTITY_NOT_FOUND,
    INVALID_CREDENTIALS,
    VALIDATION_FAIL,
    UNSPECIFIED_ERROR,
    FILE_UPLOAD_ERROR
}
