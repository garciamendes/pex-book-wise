CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE
  category (
    id UUID get_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
  );