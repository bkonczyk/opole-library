package pl.sda.library.domain.author;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addAuthor(@RequestBody @Valid AuthorCreateRequest request) {
        service.add(request);
    }

    @GetMapping
    public List<AuthorListView> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public AuthorSingleView getOne(@PathVariable Long id) {
        return service.get(id);
    }
}
