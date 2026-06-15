package BL3.BackEnd.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// O que faz mesmo?
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
