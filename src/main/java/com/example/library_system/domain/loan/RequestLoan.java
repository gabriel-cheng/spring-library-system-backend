package com.example.library_system.domain.loan;

import java.util.List;

import com.example.library_system.domain.loanbook.LoanBook;
import com.example.library_system.domain.reader.Reader;

public record RequestLoan(
    Reader reader,
    List<LoanBook> loanBook
) { }