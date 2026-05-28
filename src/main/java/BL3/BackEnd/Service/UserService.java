package BL3.BackEnd.Service;

import BL3.BackEnd.entity.User;

public interface UserService {
    // Create
    // Update
    void save(User user);

    // Read

    User get(int id);

    // Delete

    void delete(int id);

}
