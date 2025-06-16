package com.example.library_system.domain.loanbook;

import com.example.library_system.domain.book.Book;
import com.example.library_system.domain.loan.Loan;

public record RequestLoanBook(
    Loan loan,
    Book book
) { }