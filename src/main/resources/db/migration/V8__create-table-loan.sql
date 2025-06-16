CREATE TABLE loan(
    id TEXT UNIQUE NOT NULL,
    reader TEXT NOT NULL,
    book  TEXT NOT NULL,
    CONSTRAINT fk_reader FOREIGN KEY(reader)
        REFERENCES reader(id),
    CONSTRAINT fk_book FOREIGN KEY(book)
        REFERENCES book(id)
);