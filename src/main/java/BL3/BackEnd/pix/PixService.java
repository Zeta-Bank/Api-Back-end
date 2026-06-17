package BL3.BackEnd.pix;

import BL3.BackEnd.exception.PixException.ChavePixJaExisteException;
import BL3.BackEnd.exception.userException.UserNotExistsException;
import BL3.BackEnd.pix.dto.CreateChavePix;
import BL3.BackEnd.user.User;
import BL3.BackEnd.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PixService {

    private PixRepository pixRepository;
    private UserRepository userRepository;

    @Autowired
    public PixService(PixRepository pixRepository, UserRepository userRepository) {
        this.pixRepository = pixRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void createPix(CreateChavePix createChavePixDTO) {

        User user = userRepository.findById(createChavePixDTO.id())
                .orElseThrow(() -> new UserNotExistsException());

    String chave = switch (createChavePixDTO.tipo()){
        case "EMAIL" -> user.getEmail();
        case "ALEATORIO" -> UUID.randomUUID().toString();
        default -> throw new IllegalStateException("Unexpected value: " + createChavePixDTO.tipo());
    };

    if(pixRepository.findByPix(chave).isPresent()) throw new ChavePixJaExisteException();

    Pix pix = new Pix();
    pix.setIdUser(user);
    pix.setKey(chave);
    pixRepository.save(pix);

    }


    public List<Pix> getAllKeys(int idUser) {
        User user = userRepository.findById(idUser)
                .orElseThrow(()-> new UserNotExistsException());

        return pixRepository.findAllKeys(user);
    }

}
