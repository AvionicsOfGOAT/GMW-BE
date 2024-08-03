package goat.domain.data.exception;

import goat.global.config.exception.ApplicationException;

import static goat.domain.data.presentation.constant.ResponseMessage.DATA_NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_FOUND;

public class DataNotFoundException extends ApplicationException {
    public DataNotFoundException() {
        super(NOT_FOUND.value(), DATA_NOT_FOUND.getMessage());
    }
}
