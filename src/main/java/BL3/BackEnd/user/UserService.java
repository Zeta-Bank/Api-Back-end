package BL3.BackEnd.user;

import BL3.BackEnd.exception.userException.UserAlreadyExistsException;
import BL3.BackEnd.exception.userException.UserCreationError;
import BL3.BackEnd.exception.userException.UserNotExistsException;
import BL3.BackEnd.user.dto.UserCreationDto;
import BL3.BackEnd.user.dto.UserResponseDTO;
import BL3.BackEnd.user.dto.UserUpdateDto;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void createUser(UserCreationDto createDTO){
        if(userRepository.findByEmail(createDTO.email()).isPresent())
            throw new UserAlreadyExistsException();

        try{
            User user = new User();
            user.setFirstName(createDTO.firstName());
            user.setLastName(createDTO.lastName());
            user.setEmail(createDTO.email());
            user.setPassword(createDTO.password());
            user.setCpf(createDTO.cpf());
            user.setId(0);
            user.setMoneyAmount(BigDecimal.valueOf(1000));

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


            user.setFirstName(updateDto.firstName());
            user.setLastName(updateDto.lastName());
            user.setEmail(updateDto.email());
            user.setCpf(updateDto.cpf());
            user.setPassword(updateDto.password());

            userRepository.save(user);
    };

    public UserResponseDTO getUserById(int idUser){
        User userById = userRepository.findById(idUser)
                .orElseThrow(() -> new UserNotExistsException());

        UserResponseDTO responseDTO = new UserResponseDTO(
                userById.getId(),
                userById.getFirstName(),
                userById.getLastName(),
                userById.getEmail(),
                userById.getCpf(),
                userById.getMoneyAmount()
                );

        return responseDTO;
    }

    @Transactional
    public void delete(int idUser){
        User userById = userRepository.findById(idUser)
                .orElseThrow(() -> new UserNotExistsException());

        userRepository.delete(userById);
    }

    public UserResponseDTO getUserByEmail(String emailUser) {
        User user = userRepository.findByEmail(emailUser)
                .orElseThrow(() -> new UserNotExistsException());

        UserResponseDTO responseDTO = new UserResponseDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getCpf(),
                user.getMoneyAmount()
        );

        return responseDTO;
    }
}
