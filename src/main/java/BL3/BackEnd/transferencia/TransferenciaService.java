package BL3.BackEnd.transferencia;

import BL3.BackEnd.exception.PixException.ChavePixNaoEncontradaException;
import BL3.BackEnd.exception.transferenciaException.SaldoInsuficienteException;
import BL3.BackEnd.exception.transferenciaException.UserHaventTranferenciasException;
import BL3.BackEnd.exception.userException.UserNotExistsException;
import BL3.BackEnd.pix.Pix;
import BL3.BackEnd.pix.PixRepository;
import BL3.BackEnd.transferencia.dto.CreateTransferenciaDTO;
import BL3.BackEnd.transferencia.dto.TransferenciaDTO;
import BL3.BackEnd.user.User;
import BL3.BackEnd.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {

    private TranferenciaRepository transferenciaRepository;
    private UserRepository userRepository;
    private PixRepository pixRepository;

    @Autowired
    public TransferenciaService(TranferenciaRepository transferenciaRepository, UserRepository userRepository, PixRepository pixRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.userRepository = userRepository;
        this.pixRepository = pixRepository;
    }

    public List<TransferenciaDTO> getAllByUser(int userId) {
        Optional<User> remetenteOptional = userRepository.findById(userId);
        if(remetenteOptional.isEmpty()) throw new UserNotExistsException();
        
        User user = remetenteOptional.get();


        Optional<List<Transferencia>> allTransferenciasOptional = transferenciaRepository.findAllByUser(user);
        if (allTransferenciasOptional.isEmpty()) throw new UserHaventTranferenciasException();

        List<Transferencia> allTransferencias = allTransferenciasOptional.get();

        List<TransferenciaDTO> allTranferenciasResponse = allTransferencias.stream()
                .map(t -> {
                    TransferenciaDTO dto = new TransferenciaDTO(
                            t.getIdRemetente().getFirstName() + " " + t.getIdRemetente().getLastName(),
                            t.getIdDestinatario().getFirstName() + " " + t.getIdDestinatario().getLastName(),
                            t.getMoneyAmount()
                    );

                    return dto;
                })
                .toList();



        return allTranferenciasResponse;
    }

    @Transactional
    public void makeTransferencia(CreateTransferenciaDTO dto) {

        User remetente = userRepository.findById(dto.idRemetente())
                .orElseThrow(() -> new UserNotExistsException());

        Pix pix = pixRepository.findByKeyPix(dto.chavePixDestinario())
                .orElseThrow(() -> new ChavePixNaoEncontradaException());

        User destinatario = pix.getIdUser();

        if(remetente.getMoneyAmount().compareTo(dto.moneyAmount()) < 0)
            throw new SaldoInsuficienteException();

        remetente.setMoneyAmount(remetente.getMoneyAmount().subtract(dto.moneyAmount()));
        destinatario.setMoneyAmount(destinatario.getMoneyAmount().add(dto.moneyAmount()));

        userRepository.save(remetente);
        userRepository.save(destinatario);

        Transferencia t = new Transferencia();
        t.setIdRemetente(remetente);
        t.setIdDestinatario(destinatario);
        t.setIdKeyDestinatario(pix);
        t.setMoneyAmount(dto.moneyAmount());

        transferenciaRepository.save(t);
    }
}
