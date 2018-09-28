package hellomysql.hellomysql.repository;

import hellomysql.hellomysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//    https://spring.io/guides/gs/accessing-data-jpa/
    List<User> findByName(String name);
}
