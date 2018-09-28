package hellomysql.hellomysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class HellomysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellomysqlApplication.class, args);
	}
}
