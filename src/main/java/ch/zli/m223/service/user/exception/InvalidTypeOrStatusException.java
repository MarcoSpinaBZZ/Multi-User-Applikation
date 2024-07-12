package ch.zli.m223.service.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="No type or status")
public class InvalidTypeOrStatusException extends RuntimeException {
}
