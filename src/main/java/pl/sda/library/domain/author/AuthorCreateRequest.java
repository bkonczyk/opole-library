package pl.sda.library.domain.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorCreateRequest {

    @Size(min = 2, max = 20, message = "Name length should be between 0 and 20")
    @NotNull
    String name;

    @Size(min = 2, max = 20, message = "Last name length should be between 0 and 20")
    @NotNull
    String lastName;

    @NotNull
    LocalDate birthDate;
}
