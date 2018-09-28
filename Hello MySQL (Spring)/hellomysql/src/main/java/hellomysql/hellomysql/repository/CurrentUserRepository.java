package hellomysql.hellomysql.repository;

import hellomysql.hellomysql.entity.CurrentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface CurrentUserRepository extends JpaRepository<CurrentUser, Integer> {
//    https://spring.io/guides/gs/accessing-data-jpa/
    List<CurrentUser> findByName(String name);
    CurrentUser findByUsername(String username);
}
