package org.example.infra.orm.repository.impl;

import org.example.domain.entity.User;
import org.example.domain.port.UserRepository;
import org.example.infra.orm.entity.UserEntity;
import org.example.infra.orm.repository.UserEntityRepository;
import org.example.infra.orm.util.HibernateSession;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {

    private final UserEntityRepository userEntityRepository;

    public UserRepositoryImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public void create(User user) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            userEntityRepository.setSession(session);
            UserEntity userEntity = UserEntity.builder().firstname(user.getFirstname()).lastname(user.getLastname()).email(user.getEmail()).phone_number(user.getPhone_number()).build();
            userEntityRepository.create(userEntity);
            user.setId(user.getId());
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public void delete(User user) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            userEntityRepository.setSession(session);
            UserEntity userEntity = userEntityRepository.findById(user.getId());
            userEntityRepository.delete(userEntity);
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public User findById(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        userEntityRepository.setSession(session);
        try (session) {
            UserEntity userEntity = userEntityRepository.findById(id);
            return userEntity.toUser();
        }
    }

    @Override
    public List<User> searchUser(String search) {
        Session session = HibernateSession.getSessionFactory().openSession();
        userEntityRepository.setSession(session);
        try (session) {
            return userEntityRepository.findAllByKey(search)
                    .stream()
                    .map(userEntity -> userEntity.toUser())
                    .collect(Collectors.toList());
        }
    }
}
