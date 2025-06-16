package com.example.library_system.domain.loan;

import com.example.library_system.domain.book.Book;
import com.example.library_system.domain.reader.Reader;

public record RequestLoan(
    Reader reader,
    Book book
) { }