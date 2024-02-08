package org.example.domain.port;

import org.example.domain.entity.User;

import java.util.List;

public interface UserRepository {
    void create(User user);
    void delete(User user);
    User findById(int id);
    List<User> searchUser(String search);
}
