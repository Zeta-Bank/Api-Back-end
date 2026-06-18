package BL3.BackEnd.pix;

import BL3.BackEnd.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PixRepository extends JpaRepository<Pix, Integer> {
    @Query("SELECT p FROM Pix p WHERE p.user = :user")
    List<Pix> findAllKeys(@Param("user") User user);

    @Query("SELECT p FROM Pix p WHERE p.keyPix = :key")
    Optional<Pix> findByKeyPix(@Param("key") String key);
}
