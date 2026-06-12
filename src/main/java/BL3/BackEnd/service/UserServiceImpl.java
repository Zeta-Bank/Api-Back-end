package BL3.BackEnd.service;

import BL3.BackEnd.repository.user.UserDAOimpl;
import BL3.BackEnd.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    UserDAOimpl userDAOimpl;

    public UserServiceImpl(UserDAOimpl userDAOimpl) {
        this.userDAOimpl = userDAOimpl;
    }

    @Transactional
    public User save(User user){
        return userDAOimpl.save(user);
    }


    public User get(int id){
        return userDAOimpl.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDAOimpl.findAll();
    }

    @Transactional
    public void delete(User user){
        userDAOimpl.delete(user);
    }

}
