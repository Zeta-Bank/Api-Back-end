package BL3.BackEnd.repository.user;


import BL3.BackEnd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// O que faz mesmo?
@Repository
public interface UserDAOimpl extends JpaRepository<User, Integer> {}
