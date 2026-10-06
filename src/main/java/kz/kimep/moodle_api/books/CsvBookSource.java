package kz.kimep.moodle_api.books;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvBookSource implements BookSource {
    private final String resource;

    public CsvBookSource(String resource) {
        this.resource = resource;
    }

    @Override
    public List<Book> load() {
        // TODO 2: move the existing CSV parsing code here
        List<Book> books = new ArrayList<>();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resource);
        if (inputStream == null) {
            throw new IllegalArgumentException("Resource not found: " + resource);
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line = reader.readLine(); // skip header line
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    int pages = Integer.parseInt(parts[2].trim());
                    books.add(new Book(title, author, pages));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read CSV books from resource: " + resource, e);
        }
        return books;
    }
}

