package pl.sda.library.config.dev;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sda.library.domain.author.Author;
import pl.sda.library.domain.author.AuthorCreateRequest;
import pl.sda.library.domain.author.AuthorService;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Component
@RequiredArgsConstructor
@Profile("dev")
class MockDataInitializer {

    @Value("${authors.mock.count}")
    private short count;

    private final AuthorService service;
    private final AuthorMockData mockData;

    private final Random random = new Random();

    @PostConstruct
    void initializeAuthors() {
        List<String> names = mockData.getNames();
        List<String> lastNames = mockData.getLastNames();
        List<LocalDate> dates = mockData.getDates();

        for (int i = 0; i < count; i++) {
            service.add(new AuthorCreateRequest(
                    names.get(random.nextInt(names.size())),
                    lastNames.get(random.nextInt(lastNames.size())),
                    dates.get(random.nextInt(dates.size()))));
        }
    }

}
