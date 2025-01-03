CREATE TABLE bookCategory (
    bookId UUID NOT NULL,
    categoryId UUID NOT NULL,
    PRIMARY KEY (bookId, categoryId),
    FOREIGN KEY (bookId) REFERENCES book(id) ON DELETE CASCADE,
    FOREIGN KEY (categoryId) REFERENCES category(id) ON DELETE CASCADE
);