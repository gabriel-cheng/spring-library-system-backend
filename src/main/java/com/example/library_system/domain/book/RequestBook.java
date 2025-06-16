package com.example.library_system.domain.book;

import java.sql.Date;

public record RequestBook(
    String name,
    String description,
    double value,
    Date releaseDate,
    String nacionality,
    int category,
    String author
) { }
