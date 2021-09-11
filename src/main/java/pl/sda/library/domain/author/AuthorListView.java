package pl.sda.library.domain.author;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorListView {

    private String name;

    private String lastName;

    private LocalDate birthDate;
}
