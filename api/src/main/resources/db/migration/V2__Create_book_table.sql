CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE book (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    thumbnail VARCHAR(255),
    author VARCHAR(255) NOT NULL,
    totalPages INTEGER NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);