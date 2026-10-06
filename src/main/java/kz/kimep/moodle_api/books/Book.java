package kz.kimep.moodle_api.books;

public record Book(String title, String author, int pages) {
    public boolean isThick() {
        return pages > 400;
    }
}

