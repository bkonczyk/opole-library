package pl.sda.library.domain.author;

import pl.sda.library.core.exceptions.NotFoundException;

public class AuthorNotFoundException extends NotFoundException {

    public AuthorNotFoundException(Long id) {
        super("Author with id " + id + " was not found");
    }
}
