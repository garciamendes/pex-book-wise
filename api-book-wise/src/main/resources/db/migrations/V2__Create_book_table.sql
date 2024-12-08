CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE
  book (
    id UUID get_random_uuid() PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    thumbnail VARCHAR(255),
    author VARCHAR(255) NOT NULL,
    total_pages INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
  );