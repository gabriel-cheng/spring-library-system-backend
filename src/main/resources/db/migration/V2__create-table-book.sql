CREATE TABLE book(
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    category TEXT NOT NULL,
    author TEXT NOT NULL,
    value FLOAT NOT NULL
);