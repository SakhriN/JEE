package org.example.domain.port;

import org.example.domain.entity.Booking;

import java.util.List;

public interface BookingRepository {
    void create(Booking booking);
    void delete(Booking booking);
    Booking findById(int id);
    List<Booking> searchBooking(String search);
}
