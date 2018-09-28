package hellomysql.hellomysql.service;

import hellomysql.hellomysql.entity.CurrentUser;
import hellomysql.hellomysql.repository.CurrentUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface UserService {

    List<CurrentUser> findByName(String name);
}
