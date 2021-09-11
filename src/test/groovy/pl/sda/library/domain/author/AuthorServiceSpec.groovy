package pl.sda.library.domain.author

import spock.lang.Specification

import java.time.LocalDate

class AuthorServiceSpec extends Specification {

    def repository = Mock(AuthorRepository)
    def service = new AuthorService(repository)

    def 'should call repository save on save'() {
        given:
        def author = new AuthorCreateRequest("Andrzej", "Piaseczny", LocalDate.of(1960, 1, 1))
        def expectedAuthorArgument = new Author("Andrzej", "Piaseczny", LocalDate.of(1960, 1, 1))
        when:
        service.add(author)

        then:
        1 * repository.save(expectedAuthorArgument)
    }

    def 'should call find all on repository'() {
        when:
        service.findAll()

        then:
        1 * repository.findAll()
    }
}
