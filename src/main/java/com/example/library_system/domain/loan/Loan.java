package com.example.library_system.domain.loan;

import com.example.library_system.domain.book.Book;
import com.example.library_system.domain.reader.Reader;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Table(name="loan")
@Entity(name="loan")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="loanId")
public class Loan {

    @Id @GeneratedValue(strategy=GenerationType.UUID)
    private String loanId;

    private Reader reader;

    private Book book;

    public Reader getReader() {
        return this.reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Loan(RequestLoan requestLoan) {
        this.reader = requestLoan.reader();
        this.book = requestLoan.book();
    }

}
