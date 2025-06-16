CREATE TABLE loanbook(
    id TEXT UNIQUE NOT NULL,
    book TEXT NOT NULL,
    CONSTRAINT fk_book FOREIGN KEY(book)
        REFERENCES book(id)
);