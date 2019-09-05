package ru.alexandergolovnya.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for the case when someone tries to create object with already existing credentials
 *
 * @author: Alexander Golovnya <mail@alexandergolovnya.ru>
 * @created: 2019/09/04
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Not unique credentials")
@SuppressWarnings("serial")
public class NotUniqueCredentialsException extends Exception {

    public NotUniqueCredentialsException() {
    }

    public NotUniqueCredentialsException(String message) {
        super(message);
    }

    public NotUniqueCredentialsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUniqueCredentialsException(Throwable cause) {
        super(cause);
    }
}
