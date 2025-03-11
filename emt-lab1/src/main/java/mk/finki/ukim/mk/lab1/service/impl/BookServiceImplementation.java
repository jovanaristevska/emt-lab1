package mk.finki.ukim.mk.lab1.service.impl;

import mk.finki.ukim.mk.lab1.model.Book;
import mk.finki.ukim.mk.lab1.model.Category;
import mk.finki.ukim.mk.lab1.model.dto.BookDto;
import mk.finki.ukim.mk.lab1.repository.BookRepository;
import mk.finki.ukim.mk.lab1.service.AuthorService;
import mk.finki.ukim.mk.lab1.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImplementation(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        if (bookDto.getAuthor() != null &&
                authorService.findById(bookDto.getAuthor()).isPresent()) {
            return Optional.of(
                    bookRepository.save(new Book(
                            bookDto.getName(),
                            Category.valueOf(bookDto.getCategory().toUpperCase()),
                            authorService.findById(bookDto.getAuthor()).get(),
                            bookDto.getAvailableCopies())

                    )
            );
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> update(Long id, BookDto bookDto) {
        return bookRepository.findById(id).map(existingBook -> {
            if (bookDto.getName() != null) {
                existingBook.setName(bookDto.getName());
            }
            if (bookDto.getAvailableCopies() != null) {
                existingBook.setAvailableCopies(bookDto.getAvailableCopies());
            }
            return bookRepository.save(existingBook);
        });
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public void markAsRented(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));

        if (book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
        }
    }
}
