package kz.kimep.moodle_api.books;

import java.util.List;

public interface BookSource {
    List<Book> load();
}

