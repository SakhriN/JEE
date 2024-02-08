package org.example.infra.orm.repository;

import org.example.infra.orm.entity.RoomEntity;

import java.util.List;

public class RoomEntityRepository extends Repository<RoomEntity>  {
    @Override
    public RoomEntity findById(int id) {
        return session.get(RoomEntity.class, id);
    }

    public List<RoomEntity> findAllByKey(String key) {
        return (session
                .createQuery("from RoomEntity where name like :q", RoomEntity.class)
                .setParameter("q", key+"%"))
                .list();
    }

    @Override
    List<RoomEntity> findAll() {
        return null;
    }
}
