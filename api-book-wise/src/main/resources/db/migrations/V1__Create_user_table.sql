CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE
  user (
    id UUID get_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    avatar VARCHAR(255),
    total_pages_readed INTEGER DEFAULT 0,
    total_number_books_evaluated INTEGER DEFAULT 0,
    total_author_readed INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );