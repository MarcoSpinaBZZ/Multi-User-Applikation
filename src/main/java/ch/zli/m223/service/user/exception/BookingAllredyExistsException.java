package ch.zli.m223.service.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Date in use")
public class BookingAllredyExistsException extends RuntimeException {
}
