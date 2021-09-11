package pl.sda.library.domain.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;

    public void add(AuthorCreateRequest request) {

    }

    public void add(Author author) {
        repository.save(author);
    }

    public List<Author> findAll() {
        return repository.findAll();
    }
}
