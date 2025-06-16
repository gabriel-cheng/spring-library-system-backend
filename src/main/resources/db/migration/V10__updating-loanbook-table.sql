ALTER TABLE loanbook
    ADD COLUMN loan TEXT NOT NULL,
    ADD CONSTRAINT fk_loan FOREIGN KEY(loan)
        REFERENCES loan(id)
