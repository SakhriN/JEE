package biblio.repositories;

import biblio.models.Books;
import biblio.models.BooksEntity;
import biblio.utils.HibernateSession;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class BookRepositoryImpl implements BooksRepository {



    private final BooksEntityRepository bookEntityRepository;

    public BookRepositoryImpl(BooksEntityRepository bookEntityRepository) {
        this.bookEntityRepository = bookEntityRepository;
    }

    @Override
    public boolean Create(Books books) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        boolean test = false;
        try (session) {
            bookEntityRepository.setSession(session);
            BooksEntity booksEntity = new BooksEntity.Builder().name_book(books.getName_book()).description_book(books.getDescription_book()).build();
            bookEntityRepository.create(booksEntity);
            books.setId(books.getId());
            session.getTransaction().commit();
            test = true;
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
        return test;
    }

    @Override
    public void Delete(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            bookEntityRepository.setSession(session);
            BooksEntity bookEntity = bookEntityRepository.findById(id);
            bookEntityRepository.delete(bookEntity);
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public Books ReadOne(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        bookEntityRepository.setSession(session);
        try (session) {
            BooksEntity booksEntity = bookEntityRepository.findById(id);
            return booksEntity.toBook();
        }
    }

    @Override
    public List<Books> searchBook(String search) {
        Session session = HibernateSession.getSessionFactory().openSession();
        bookEntityRepository.setSession(session);
        try (session) {
            return bookEntityRepository.findAllByKey(search)
                    .stream()
                    .map(bookEntity -> bookEntity.toBook())
                    .collect(Collectors.toList());
        }
    }
}
