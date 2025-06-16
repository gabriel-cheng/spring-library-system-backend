ALTER TABLE book
    ADD CONSTRAINT fk_category FOREIGN KEY(category)
        REFERENCES category(id),
    ADD CONSTRAINT fk_author FOREIGN KEY(author)
        REFERENCES author(id)