package BL3.BackEnd.Service;

import BL3.BackEnd.dao.UserDAOimpl;
import BL3.BackEnd.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    UserDAOimpl userDAOimpl;

    public UserServiceImpl(UserDAOimpl userDAOimpl) {
        this.userDAOimpl = userDAOimpl;
    }

    @Transactional
    public void save(User user){
        userDAOimpl.save(user);
    }


    public User get(int id){
        return userDAOimpl.get(id);
    }

    // @Transactional
    public void delete(int id){
        userDAOimpl.delete(id);
    }

}
