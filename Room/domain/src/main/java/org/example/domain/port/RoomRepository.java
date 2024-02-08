package org.example.domain.port;

import org.example.domain.entity.Room;

import java.util.List;

public interface RoomRepository {
    void create(Room room);
    void delete(Room room);
    Room findById(int id);
    List<Room> searchRoom(String search);
}
