package biblio.service;

import biblio.models.Books;
import biblio.repositories.BooksRepository;

import java.util.List;


public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Books createBooks(String name_book, String description_book) {
        //Logique de contrôle
        if (name_book.length() < 3) {
            throw new RuntimeException("Title length must be gt 3 char");
        }
        //...
        Books books = new Books.Builder().name_book(name_book).description_book(description_book).build();
        booksRepository.Create(books);
        return books;
    }

    public void deleteBooks(int id) {
        Books books = booksRepository.ReadOne(id);
        if (books != null) {
            booksRepository.Delete(id);
        } else {
            throw new RuntimeException("Book not found");
         }
    }

    public List<Books> searchBooks(String search) {
        if (search.length() < 3) {
            throw new RuntimeException("search word length must be gt 3 char");
        }
        List<Books> list = booksRepository.searchBook(search);
        return list;
    }
}
