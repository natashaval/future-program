package hellomysql.hellomysql.service;

import hellomysql.hellomysql.entity.User;
import hellomysql.hellomysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    List<User> findByName(String name);
}
