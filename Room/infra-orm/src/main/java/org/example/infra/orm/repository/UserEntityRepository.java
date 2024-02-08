package org.example.infra.orm.repository;

import org.example.infra.orm.entity.UserEntity;

import java.util.List;

public class UserEntityRepository extends Repository<UserEntity>  {
    @Override
    public UserEntity findById(int id) {
        return session.get(UserEntity.class, id);
    }

    public List<UserEntity> findAllByKey(String key) {
        return (session
                .createQuery("from UserEntity where firstname like :q", UserEntity.class)
                .setParameter("q", key+"%"))
                .list();
    }

    @Override
    List<UserEntity> findAll() {
        return null;
    }
}
