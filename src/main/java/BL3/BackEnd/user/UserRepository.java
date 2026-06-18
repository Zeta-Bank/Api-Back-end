package BL3.BackEnd.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("Select p.user FROM Pix p WHERE p.keyPix = :key")
    User findByPix(@Param("key") String key);

    Optional<User> findByEmail(String email);
}
