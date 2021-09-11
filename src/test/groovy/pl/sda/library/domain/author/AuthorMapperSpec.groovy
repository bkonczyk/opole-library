package pl.sda.library.domain.author

import spock.lang.Specification

import java.time.LocalDate

class AuthorMapperSpec extends Specification {

    def 'should map AuthorCreateRequest to Author'() {
        given:
        def request = new AuthorCreateRequest("Najdrzej", "Nejmar", LocalDate.of(1969, 8, 10))

        when:
        def result = AuthorMapper.MAPPER.toAuthor(request)

        then:
        result.id == null
        result.name == request.name
        result.lastName == request.lastName
        result.birthDate == request.birthDate
        result.books == []
    }
}
