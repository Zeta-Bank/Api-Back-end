package BL3.BackEnd.transferencia;

import BL3.BackEnd.exception.userException.UserNotExistsException;
import BL3.BackEnd.transferencia.dto.TransferenciaDTO;
import BL3.BackEnd.user.User;
import BL3.BackEnd.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {

    TranferenciaRepository tranferenciaRepository;
    UserRepository userRepository;

    @Autowired
    public TransferenciaService(TranferenciaRepository tranferenciaRepository, UserRepository userRepository) {
        this.tranferenciaRepository = tranferenciaRepository;
        this.userRepository = userRepository;
    }

    public List<TransferenciaDTO> getAllByUser(int userId) {
        Optional<User> remetenteOptional = userRepository.findById(userId);
        if(remetenteOptional.isEmpty()) throw new UserNotExistsException();
        
        User user = remetenteOptional.get();


        // e se o usuário não tiver transferencias?
        // criar exceção
        List<Transferencia> allTransferencias = tranferenciaRepository.findAllByUser(user);

        List<TransferenciaDTO> allTranferenciasResponse = allTransferencias.stream()
                .map(t -> {
                    TransferenciaDTO dto = new TransferenciaDTO(
                            user.getFirstName() + " " + user.getLastName(),
                            t.getIdDestinatario().getFirstName() + " " + t.getIdDestinatario().getLastName(),
                            t.getMoneyAmount()
                    );

                    return dto;
                })
                .toList();


        return allTranferenciasResponse;
    }
}
