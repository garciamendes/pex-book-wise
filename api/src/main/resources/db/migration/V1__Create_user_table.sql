CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE account (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    avatar VARCHAR(255),
    totalPagesReaded INTEGER DEFAULT 0,
    totalNumberBooksEvaluated INTEGER DEFAULT 0,
    totalAuthorReaded INTEGER DEFAULT 0,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);