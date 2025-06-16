package com.example.library_system.domain.book;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name="book")
@Entity(name="book")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="bookId")
public class Book {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private String bookId;

    private String name;

    private String description;

    private double value;

    @Column(name="relase_date")
    private Date releaseDate;

    private String nacionality;

    @ManyToOne
    @JoinColumn(name="id")
    private int category;

    @ManyToOne
    @JoinColumn(name="id")
    private String author;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double value() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getNacionality() {
        return this.nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(RequestBook requestBook) {
        this.name = requestBook.name();
        this.description = requestBook.description();
        this.value = requestBook.value();
        this.releaseDate = requestBook.releaseDate();
        this.nacionality = requestBook.nacionality();
    }

}
