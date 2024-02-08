package org.example.infra.orm.repository.impl;

import org.example.domain.entity.Room;
import org.example.domain.port.RoomRepository;
import org.example.infra.orm.entity.RoomEntity;
import org.example.infra.orm.repository.RoomEntityRepository;
import org.example.infra.orm.util.HibernateSession;
import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;

public class RoomRepositoryImpl implements RoomRepository {

    private final RoomEntityRepository roomEntityRepository;

    public RoomRepositoryImpl(RoomEntityRepository roomEntityRepository) {
        this.roomEntityRepository = roomEntityRepository;
    }

    @Override
    public void create(Room room) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            roomEntityRepository.setSession(session);
            RoomEntity roomEntity = RoomEntity.builder().bgndate(room.getBgndate()).enddate(room.getEnddate()).name(room.getName()).build();
            roomEntityRepository.create(roomEntity);
            room.setId(room.getId());
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public void delete(Room room) {
        Session session = HibernateSession.getSessionFactory().openSession();
        session.beginTransaction();
        try (session) {
            roomEntityRepository.setSession(session);
            RoomEntity roomEntity = roomEntityRepository.findById(room.getId());
            roomEntityRepository.delete(roomEntity);
            session.getTransaction().commit();
        }catch (Exception ex) {
            session.getTransaction().rollback();
            throw ex;
        }
    }

    @Override
    public Room findById(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        roomEntityRepository.setSession(session);
        try (session) {
            RoomEntity roomEntity = roomEntityRepository.findById(id);
            return roomEntity.toRoom();
        }
    }

    @Override
    public List<Room> searchRoom(String search) {
        Session session = HibernateSession.getSessionFactory().openSession();
        roomEntityRepository.setSession(session);
        try (session) {
            return roomEntityRepository.findAllByKey(search)
                    .stream()
                    .map(roomEntity -> roomEntity.toRoom())
                    .collect(Collectors.toList());
        }
    }
}
