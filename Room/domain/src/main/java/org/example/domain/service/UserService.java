package org.example.domain.service;

import org.example.domain.entity.User;
import org.example.domain.port.UserRepository;

import java.sql.Date;
import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String firstname,String lastname,String email,String phone_number) {
        //Logique de contrôle
        if(firstname.length() < 3) {
            throw new RuntimeException("Name length must be gt 3 char");
        }
        //...
        User user = new User.Builder().firstname(firstname).lastname(lastname).email(email).phone_number(phone_number).build();
        userRepository.create(user);
        return user;
    }

    public void deleteUser(int id) {
        User user = userRepository.findById(id);
        if(user == null) {
            throw new RuntimeException("User not found");
        }
        userRepository.delete(user);
    }

    public List<User> searchUser(String search) {
        if(search.length() < 3) {
            throw new RuntimeException("search word length must be gt 3 char");
        }
        List<User> list = userRepository.searchUser(search);
        return list;
    }
}
