package study.projects_spring.firstendpoint.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsurpportedMathOperationException extends RuntimeException {

    public UnsurpportedMathOperationException(String message) {
        super(message);

    }

}
