package pl.sda.library.domain.author

import spock.lang.Specification

import javax.swing.text.html.Option
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

    def 'should find all'() {
        given:
        def author = new Author(1L, "Daruje", "Sobie", LocalDate.MIN, [])
        repository.findAll() >> [author]

        when:
        def result = service.findAll()

        then:
        result != null
        result.size() == 1
        with(result.first()) {
            name == author.name
            lastName == author.lastName
            birthDate == author.birthDate
        }
    }

    def 'should throw AuthorNotFoundException'() {
        given:
        repository.findById(_ as Long) >> Optional.empty()

        when:
        service.get(2L)

        then:
        def e = thrown(AuthorNotFoundException)
        e.message == "Author with id 2 was not found"
    }

    def 'should return author by id if exists'() {
        given:
        def id = 1L
        def author = new Author(id, "Daruje", "Sobie", LocalDate.MIN, [])
        repository.findById(id) >> Optional.of(author)

        when:
        def result = service.get(id)

        then:
        with(result) {
            name == author.name
            lastName == author.lastName
            birthDate == author.birthDate
            books == author.books
        }
    }
}
