package BL3.BackEnd.user;


import BL3.BackEnd.user.dto.UserCreationDto;
import BL3.BackEnd.user.dto.UserUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("users")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserCreationDto userDTO){
        userService.createUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("{idUser}")
    public User getUserById(@PathVariable int idUser){
       return userService.getUserById(idUser);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserUpdateDto updateDto){
        userService.updateUser(updateDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{idUser}")
    void deleteUser(@PathVariable int userId){
        userService.delete(userId);
    }

}
