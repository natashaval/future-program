package hellomysql.hellomysql.service;

import hellomysql.hellomysql.entity.CurrentUser;
import hellomysql.hellomysql.repository.CurrentUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    @PersistenceContext
//    private EntityManager em;

    @Autowired
    CurrentUserRepository userRepository;

    @Override
    public List<CurrentUser> findByName(String name){
//        TypedQuery query = em.createQuery("select a from User u where u.email = ?1", User.class);
//        query.setParameter(1, email);
//        return query.getResultList();
        return userRepository.findByName(name);
    }
}
