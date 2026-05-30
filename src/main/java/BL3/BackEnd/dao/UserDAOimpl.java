package BL3.BackEnd.dao;


import BL3.BackEnd.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


// O que faz mesmo?
@Repository
public class UserDAOimpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOimpl(EntityManager entityManager){this.entityManager = entityManager;}

    @Override
    public User save(@RequestBody User user) {
        return entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public List<User> getAll() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);
        return query.getResultList();
    }

    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
