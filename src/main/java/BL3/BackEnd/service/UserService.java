package BL3.BackEnd.service;

import BL3.BackEnd.entity.User;

import java.util.List;

public interface UserService {
    // Create
    // Update
    User save(User user);

    // Read
    User get(int id);

    List<User> getAll();

    // Delete
    void delete(User id);

}
