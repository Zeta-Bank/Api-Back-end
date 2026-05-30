package BL3.BackEnd.Service;

import BL3.BackEnd.dao.UserDAOimpl;
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
        return userDAOimpl.getAll();
    }

    @Transactional
    public void delete(int id){
        userDAOimpl.delete(id);
    }

}
