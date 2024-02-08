package org.example.domain.service;

import org.example.domain.entity.Room;
import org.example.domain.port.RoomRepository;

import java.sql.Date;
import java.util.List;

public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room createRoom(String name, Date bgndate, Date enddate) {
        //Logique de contrôle
        if(name.length() < 3) {
            throw new RuntimeException("Name length must be gt 3 char");
        }
        //...
        Room room = new Room.Builder().name(name).bgndate(bgndate).enddate(enddate).build();
        roomRepository.create(room);
        return room;
    }

    public void deleteRoom(int id) {
        Room room = roomRepository.findById(id);
        if(room == null) {
            throw new RuntimeException("Room not found");
        }
        roomRepository.delete(room);
    }

    public List<Room> searchRoom(String search) {
        if(search.length() < 3) {
            throw new RuntimeException("search word length must be gt 3 char");
        }
        List<Room> list = roomRepository.searchRoom(search);
        return list;
    }
}
