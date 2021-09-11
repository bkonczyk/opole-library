package pl.sda.library.domain.book;

import pl.sda.library.domain.author.Author;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

    @Id
    private Long id;

    private String title;

    private Short year;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private Author author;
}
