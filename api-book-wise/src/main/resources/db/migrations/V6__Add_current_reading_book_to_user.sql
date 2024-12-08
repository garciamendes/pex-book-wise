ALTER TABLE user
ADD COLUMN current_reading_book_id UUID;

ALTER TABLE user ADD CONSTRAINT fk_current_reading_book FOREIGN KEY (current_reading_book_id) REFERENCES book (id) ON DELETE SET NULL;