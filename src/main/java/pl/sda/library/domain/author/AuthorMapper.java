package pl.sda.library.domain.author;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
interface AuthorMapper {

    AuthorMapper MAPPER = getMapper(AuthorMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "books", ignore = true)
    })
    Author toAuthor(AuthorCreateRequest request);
}
