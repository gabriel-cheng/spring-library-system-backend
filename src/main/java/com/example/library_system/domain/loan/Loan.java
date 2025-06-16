package com.example.library_system.domain.loan;

import java.util.List;

import com.example.library_system.domain.loanbook.LoanBook;
import com.example.library_system.domain.reader.Reader;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @Column(name="id")
    private String loanId;

    @ManyToOne
    @JoinColumn(name="reader")
    private Reader reader;

    @OneToMany(mappedBy="loan", cascade=CascadeType.REMOVE, orphanRemoval=true)
    private List<LoanBook> loanBook;

    public Reader getReader() {
        return this.reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public List<LoanBook> getLoanBook() {
        return this.loanBook;
    }

    public void setLoanBook(List<LoanBook> loanBook) {
        this.loanBook = loanBook;
    }

    public Loan(RequestLoan requestLoan) {
        this.reader = requestLoan.reader();
        this.loanBook = requestLoan.loanBook();
    }

}
