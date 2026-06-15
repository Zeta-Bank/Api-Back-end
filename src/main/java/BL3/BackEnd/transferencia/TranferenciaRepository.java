package BL3.BackEnd.transferencia;

import BL3.BackEnd.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TranferenciaRepository extends JpaRepository<Transferencia, Integer> {

    @Query("SELECT t FROM Transferencia t WHERE t.idRemetente = :user OR t.idDestinatario = :user")
    Optional<List<Transferencia>> findAllByUser(@Param("user") User user);

}
