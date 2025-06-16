package com.example.library_system.domain.author;

import java.util.Date;
import java.util.List;

import com.example.library_system.domain.book.Book;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name="author")
@Entity(name="author")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="authorId")
public class Author {
    
    @Id @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="id")
    private String authorId;

    private String firstname;

    private String surname;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    private String biography;

    private String nacionality;

    @OneToMany(mappedBy="author", cascade=CascadeType.REMOVE, orphanRemoval=true)
    private List<Book> book;

    public String getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBiography() {
        return this.biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getNacionality() {
        return this.nacionality;
    }

    public void setNacionality(String nacionality)  {
        this.nacionality = nacionality;
    }

    public List<Book> getBook() {
        return this.book;
    }

    public void setBook(List<Book> book)  {
        this.book = book;
    }

    public Author(RequestAuthor requestAuthor) {
        this.firstname = requestAuthor.firstname();
        this.surname = requestAuthor.surname();
        this.dateOfBirth = requestAuthor.dateOfBirth();
        this.biography = requestAuthor.biography();
        this.nacionality = requestAuthor.nacionality();
    }

}
