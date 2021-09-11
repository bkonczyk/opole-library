package pl.sda.library.config.dev;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.library.domain.author.Author;
import pl.sda.library.domain.author.AuthorService;

import javax.annotation.PostConstruct;
import java.util.Random;

import static pl.sda.library.config.dev.AuthorMockData.*;

@Component
@RequiredArgsConstructor
@Profile("dev")
class MockDataInitializer {

    @Value("${authors.mock.count}")
    private short count;
    private final AuthorService service;
    private final Random random = new Random();

    @PostConstruct
    void initializeAuthors() {
        for (int i = 0; i < count; i++) {
            Author author = new Author(
                    NAMES.get(random.nextInt(NAMES.size())),
                    LAST_NAMES.get(random.nextInt(LAST_NAMES.size())),
                    DATES.get(random.nextInt(DATES.size())));
            service.add(author);
        }
    }

}
