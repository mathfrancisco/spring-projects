package study.projects_spring.firstendpoint.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp,String message,String details) {
}
