package mk.finki.ukim.mk.lab1.service;

import mk.finki.ukim.mk.lab1.model.Book;
import mk.finki.ukim.mk.lab1.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> save(BookDto bookDto);

    Optional<Book> findById(Long id);

    Optional<Book> update(Long id, BookDto bookDto);

    void deleteById(Long id);

    void markAsRented(Long id);
}
