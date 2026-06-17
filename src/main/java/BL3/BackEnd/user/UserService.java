package BL3.BackEnd.user;

import BL3.BackEnd.exception.userException.UserCreationError;
import BL3.BackEnd.exception.userException.UserNotExistsException;
import BL3.BackEnd.user.dto.UserCreationDto;
import BL3.BackEnd.user.dto.UserUpdateDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void createUser(UserCreationDto userDTO){
        try{
            User user = new User();

            user.setFirstName(userDTO.fistName());
            user.setLastName(userDTO.lastName());
            user.setEmail(userDTO.email());
            user.setPassword(userDTO.password());
            user.setId(0);

            userRepository.save(user);
        }catch (RuntimeException e){
            // printStack é para os fracos
            throw new UserCreationError();
        }
    }

    // Muito parecido com o de cima, dava para fazer algo aqui evitar esse boilerplate
    @Transactional
    public void updateUser(UserUpdateDto updateDto){
            User user = userRepository.findById(updateDto.id())
                    .orElseThrow(() -> new UserNotExistsException());;


            user.setFirstName(updateDto.fistName());
            user.setLastName(updateDto.lastName());
            user.setEmail(updateDto.email());
            user.setPassword(updateDto.password());

            userRepository.save(user);
    };

    public User getUserById(int idUser){
        User userById = userRepository.findById(idUser)
                .orElseThrow(() -> new UserNotExistsException());
        return userById;
    }

    @Transactional
    public void delete(int idUser){
        User userById = userRepository.findById(idUser)
                .orElseThrow(() -> new UserNotExistsException());

        userRepository.delete(userById);
    }

}
