package com.example.library_system.domain.reader;

public record RequestReader(
    String firstname,
    String surname,
    String cpf,
    String email,
    String cel
) { }