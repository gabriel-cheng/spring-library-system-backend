ALTER TABLE book
    ADD COLUMN release_date DATE NOT NULL,
    ADD COLUMN nacionality TEXT NOT NULL;

ALTER TABLE author
    ADD COLUMN nacionality TEXT NOT NULL;