package BL3.BackEnd.controller;


import BL3.BackEnd.dao.UserDAOimpl;
import BL3.BackEnd.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class UserController {

    UserDAOimpl userDAOimpl;

    public UserController(UserDAOimpl userDAOimpl) {
        this.userDAOimpl = userDAOimpl;
    }

    @GetMapping("{idUsuario}")
    public User getUser(@PathVariable int idUsuario){
       User user = userDAOimpl.
    }

}
