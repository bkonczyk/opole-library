package pl.sda.library.domain.author;

import org.springframework.data.jpa.repository.JpaRepository;

interface AuthorRepository extends JpaRepository<Author, Long> {
}
