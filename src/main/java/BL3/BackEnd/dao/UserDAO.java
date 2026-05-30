package BL3.BackEnd.dao;

import BL3.BackEnd.entity.User;

import java.util.List;

public interface UserDAO {

    // Create
    // Update
    User save(User user);

    // Read

    User getById(int id);
    List<User> getAll();

    // Delete

    void delete(int id);
}
