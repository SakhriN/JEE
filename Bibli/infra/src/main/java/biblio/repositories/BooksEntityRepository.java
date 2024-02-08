package biblio.repositories;

import biblio.models.BooksEntity;

import java.util.List;

public class BooksEntityRepository extends BaseEntityRepository<BooksEntity>  {
    @Override
    public BooksEntity findById(int id) {
        return session.get(BooksEntity.class, id);
    }

    public List<BooksEntity> findAllByKey(String key) {
        return (session
                .createQuery("from books where name_book like :q", BooksEntity.class)
                .setParameter("q", key+"%"))
                .list();
    }

    @Override
    List<BooksEntity> findAll() {
        return null;
    }
}
