package pl.sda.library.domain.author;

import org.mapstruct.Mapper;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper
interface AuthorMapper {

    AuthorMapper MAPPER = getMapper(AuthorMapper.class);

    Author toAuthor(AuthorCreateRequest request);
}
