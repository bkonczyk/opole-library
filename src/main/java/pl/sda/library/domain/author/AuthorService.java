package pl.sda.library.domain.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static pl.sda.library.domain.author.AuthorMapper.MAPPER;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;

    public void add(AuthorCreateRequest request) {
        Author author = MAPPER.toAuthor(request);
        repository.save(author);
    }

    public List<AuthorListView> findAll() {
        return repository.findAll()
                .stream()
                .map(MAPPER::toAuthorListView)
                .collect(toList());
    }

    public AuthorSingleView get(Long id) {
        return repository.findById(id).map(MAPPER::toAuthorSingleView).orElseThrow(() -> new AuthorNotFoundException(id));
    }
}
