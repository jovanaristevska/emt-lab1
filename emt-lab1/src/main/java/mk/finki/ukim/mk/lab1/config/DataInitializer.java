package mk.finki.ukim.mk.lab1.config;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab1.model.Author;
import mk.finki.ukim.mk.lab1.model.Book;
import mk.finki.ukim.mk.lab1.model.Category;
import mk.finki.ukim.mk.lab1.model.Country;
import mk.finki.ukim.mk.lab1.repository.AuthorRepository;
import mk.finki.ukim.mk.lab1.repository.BookRepository;
import mk.finki.ukim.mk.lab1.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init() {

        Country USA =  countryRepository.save(new Country("United States", "North America"));


        Author author1 = authorRepository.save(new Author("Rebecca", "Yarros", USA));
        Author author2 = authorRepository.save(new Author("Kristin", "Hannah", USA));
        Author author3 = authorRepository.save(new Author("Rebecca", "Yarros", USA));


        Book book1 = bookRepository.save(new Book("Iron Flames", Category.NOVEL , author1, 250));
        Book book2 = bookRepository.save(new Book("The Women", Category.BIOGRAPHY,author2, 350));
        Book book3 = bookRepository.save(new Book("Deep End", Category.FANTASY, author3, 450));

        bookRepository.saveAll(List.of(book1, book2, book3));
    }
}
