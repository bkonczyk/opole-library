package pl.sda.library.domain.author;

import lombok.Value;
import pl.sda.library.domain.book.Book;

import java.time.LocalDate;
import java.util.List;

@Value
class AuthorSingleView {

    private String name;

    private String lastName;

    private LocalDate birthDate;

    private List<Book> books;
}
