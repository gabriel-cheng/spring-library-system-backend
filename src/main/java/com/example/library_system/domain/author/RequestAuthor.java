package com.example.library_system.domain.author;

import java.sql.Date;

public record RequestAuthor(
    String firstname,
    String surname,
    Date dateOfBirth,
    String biography,
    String nacionality
) { }
