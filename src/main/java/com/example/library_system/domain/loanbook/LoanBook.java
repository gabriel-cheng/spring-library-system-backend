package com.example.library_system.domain.loanbook;

import com.example.library_system.domain.book.Book;
import com.example.library_system.domain.loan.Loan;

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

@Table(name="loanbook")
@Entity(name="loanbook")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="loanBookId")
public class LoanBook {

    @Id @GeneratedValue(strategy=GenerationType.UUID)
    private String loanBookId;

    @ManyToOne
    @JoinColumn(name="loan")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name="book")
    private Book book;

    public Loan getLoan() {
        return this.loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LoanBook(RequestLoanBook requestLoanBook) {
        this.loan = requestLoanBook.loan();
        this.book = requestLoanBook.book();
    }

}
