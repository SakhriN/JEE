package biblio.repositories;

import biblio.models.Books;

import java.util.List;

public interface BooksRepository {

    public boolean Create(Books books);

    public Books ReadOne(int id);

    public void Delete(int id);

    List<Books> searchBook(String search);
}
