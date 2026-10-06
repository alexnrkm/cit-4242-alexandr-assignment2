package kz.kimep.moodle_api.books;

import java.util.List;

public class InMemoryBookSource implements BookSource {
    @Override
    public List<Book> load() {
        // TODO 1: return a List.of(...) with three books
        return List.of(
            new Book("Clean Code", "Robert C. Martin", 464),
            new Book("Design Patterns", "Erich Gamma", 395),
            new Book("Refactoring", "Martin Fowler", 448)
        );
    }
}

