package pl.sda.library.core.exceptions;

import lombok.Data;


@Data
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
