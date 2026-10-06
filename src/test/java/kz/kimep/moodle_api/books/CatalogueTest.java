package kz.kimep.moodle_api.books;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CatalogueTest {

    // TODO 3: in one test, use InMemoryBookSource instead of the file
    @Test
    void shouldLoadBooksFromInMemorySourceWithoutTouchingDisk() {
        BookSource inMemorySource = new InMemoryBookSource();
        Catalogue catalogue = new Catalogue(inMemorySource);

        List<Book> books = catalogue.getAllBooks();

        assertEquals(3, books.size());
        assertEquals("Clean Code", books.get(0).title());
        assertEquals(2, catalogue.getThickBooks().size());
    }

    @Test
    void shouldLoadBooksFromCsvSource() {
        BookSource csvSource = new CsvBookSource("books.csv");
        Catalogue catalogue = new Catalogue(csvSource);

        List<Book> books = catalogue.getAllBooks();

        assertFalse(books.isEmpty());
        assertEquals(3, books.size());
        assertEquals("Clean Code", books.get(0).title());
    }
}

