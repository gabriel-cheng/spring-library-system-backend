package com.example.library_system.domain.category;


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

@Table(name="category")
@Entity(name="category")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="categoryId")
public class Category {

    @Id @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name="id")
    private String categoryId;

    private String name;

    private int code;

    @OneToMany(mappedBy="category", cascade=CascadeType.REMOVE, orphanRemoval=true)
    private List<Book> book;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Book> getBook() {
        return this.book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public Category(RequestCategory requestCategory) {
        this.name = requestCategory.name();
        this.code = requestCategory.code();
    }

}
