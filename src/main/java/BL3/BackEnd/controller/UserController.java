package BL3.BackEnd.controller;


import BL3.BackEnd.service.UserServiceImpl;
import BL3.BackEnd.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("users")
@RestController
public class UserController {

    UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        user.setId(0);
        userService.save(user);
    }

    @GetMapping("{idUser}")
    public User getUser(@PathVariable int idUser){
       return userService.get(idUser);
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAll();
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.save(user);
    }

    @DeleteMapping
    void deleteUser(@PathVariable int userId){
        userService.delete(userService.get(userId));
    }


}
