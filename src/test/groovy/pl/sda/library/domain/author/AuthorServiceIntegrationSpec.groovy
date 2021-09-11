package pl.sda.library.domain.author

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import java.time.LocalDate

@SpringBootTest
class AuthorServiceIntegrationSpec extends Specification {

    @Autowired
    private AuthorService service

    def 'should add and find authors'() {
        given:
        def author = new Author("Andrzej", "Rutkowski", LocalDate.of(1960, 1, 1))

        when:
        service.add(author)

        and:
        def result = service.findAll()

        then:
        result != null
        result.size() == 1
        with(result.first()) {

            id != null
            name == author.name
            lastName == author.lastName
            birthDate == author.birthDate
            books == []
        }
    }
}
