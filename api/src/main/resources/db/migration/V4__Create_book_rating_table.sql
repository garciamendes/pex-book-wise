CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE bookRating (
    id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
    accountId UUID NOT NULL,
    bookId UUID NOT NULL,
    rating INTEGER CHECK (
        rating >= 1
            AND rating <= 5
        ),
    comment TEXT,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (accountId) REFERENCES account(id) ON DELETE CASCADE,
    FOREIGN KEY (bookId) REFERENCES book(id) ON DELETE CASCADE
);