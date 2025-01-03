ALTER TABLE account
    ADD COLUMN currentReadingBookId UUID;

ALTER TABLE account ADD CONSTRAINT fk_current_reading_book FOREIGN KEY (currentReadingBookId) REFERENCES book(id) ON DELETE SET NULL;