package mk.finki.ukim.mk.lab1.service;

import mk.finki.ukim.mk.lab1.model.Author;
import mk.finki.ukim.mk.lab1.model.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();

    Optional<Author> save(AuthorDto authorDto);

    Optional<Author> findById(Long id);

    Optional<Author> update(Long id, AuthorDto authorDto);

    void deleteById(Long id);

}
