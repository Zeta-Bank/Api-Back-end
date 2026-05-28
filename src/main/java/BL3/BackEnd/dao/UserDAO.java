package BL3.BackEnd.dao;

import BL3.BackEnd.entity.User;

public interface UserDAO {

    // Create

    void create(User user);

    // Read

    User get(int id);

    // Update

    int update(User user);

    // Delete

    boolean delete(int id);
}
