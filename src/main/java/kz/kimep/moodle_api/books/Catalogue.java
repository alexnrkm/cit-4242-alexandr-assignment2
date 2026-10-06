package kz.kimep.moodle_api.books;

import java.util.List;

public class Catalogue {
    private final BookSource bookSource;

    public Catalogue(BookSource bookSource) {
        this.bookSource = bookSource;
    }

    public List<Book> getAllBooks() {
        return bookSource.load();
    }

    public int count() {
        return bookSource.load().size();
    }

    public List<Book> getThickBooks() {
        return bookSource.load().stream()
                .filter(Book::isThick)
                .toList();
    }
}

