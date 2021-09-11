package pl.sda.library.core.exceptions;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorResponse {

    String message;
    LocalDateTime dateTime;
}
