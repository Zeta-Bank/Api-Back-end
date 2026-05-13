package BL3.BackEnd.dao;

public interface User {

    // Create

    void create(User user);

    // Read

    User get(int id);

    // Update

    int update(User user);

    // Delete

    boolean delete(int id);
}
