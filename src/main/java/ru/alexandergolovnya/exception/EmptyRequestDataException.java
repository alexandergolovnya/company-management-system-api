package ru.alexandergolovnya.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for cases when client send to server empty request
 */

@ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Received data is empty")
@SuppressWarnings("serial")
public class EmptyRequestDataException extends Exception {

    public EmptyRequestDataException() {
    }

    public EmptyRequestDataException(String message) {
        super(message);
    }

    public EmptyRequestDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyRequestDataException(Throwable cause) {
        super(cause);
    }
}
