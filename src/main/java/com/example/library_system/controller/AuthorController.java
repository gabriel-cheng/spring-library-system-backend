package com.example.library_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_system.domain.author.Author;
import com.example.library_system.domain.author.AuthorRepository;
import com.example.library_system.domain.author.RequestAuthor;
import com.example.library_system.exceptions.ResourceCannotBeEmptyException;
import com.example.library_system.exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> allAuthors = authorRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK)
            .body(allAuthors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getOneAuthor(
        @PathVariable String id
    ) throws ResourceNotFoundException {
        Author authorFound = authorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Author " + id + " not found!"));

        return ResponseEntity.status(HttpStatus.OK)
            .body(authorFound);
    }

    @PostMapping
    public ResponseEntity<String> registerNewAuthor(
        @RequestBody @Validated RequestAuthor author
    ) throws ResourceCannotBeEmptyException {
        Author newAuthor = new Author(author);

        authorDataValidator(author);

        authorRepository.save(newAuthor);

        return ResponseEntity.status(HttpStatus.OK)
            .body("Author registered successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAuthor(
        @RequestBody @Validated RequestAuthor author,
        @PathVariable String id
    ) throws ResourceNotFoundException, ResourceCannotBeEmptyException {
        Author authorFound = authorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Author " + id + " not found!"));

        authorDataValidator(author);

        authorFound.setFirstname(author.firstname());
        authorFound.setSurname(author.surname());
        authorFound.setDateOfBirth(author.dateOfBirth());
        authorFound.setBiography(author.biography());
        authorFound.setNacionality(author.nacionality());

        authorRepository.save(authorFound);

        return ResponseEntity.status(HttpStatus.OK)
            .body("Author updated successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(
        @PathVariable String id
    ) throws ResourceNotFoundException {
        Author authorFound = authorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Author " + id + " not found!"));
        
        authorRepository.delete(authorFound);

        return ResponseEntity.status(HttpStatus.OK)
            .body("Author deleted successfully!");
    }

    private void authorDataValidator(RequestAuthor author) throws ResourceCannotBeEmptyException {
        if(author.firstname().isEmpty()) {
            throw new ResourceCannotBeEmptyException("The name can't be empty!");
        }
        if(author.surname().isEmpty()) {
            throw new ResourceCannotBeEmptyException("The surname can't be empty!");
        }
        if(author.dateOfBirth() == null) {
            throw new ResourceCannotBeEmptyException("The date of birth can't be empty!");
        }
        if(author.biography().isEmpty()) {
            throw new ResourceCannotBeEmptyException("The biography can't be empty!");
        }
        if(author.nacionality().isEmpty()) {
            throw new ResourceCannotBeEmptyException("The nacionality can't be empty!");
        }
    }

}
