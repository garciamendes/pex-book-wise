CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE
  category (
    id UUID gen_random_uuid() PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
  );