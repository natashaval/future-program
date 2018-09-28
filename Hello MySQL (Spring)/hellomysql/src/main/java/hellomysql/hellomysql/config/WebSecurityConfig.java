package hellomysql.hellomysql.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//https://spring.io/guides/gs/securing-web/

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // The configure(HttpSecurity) method defines which URL paths should be secured and which should not
        http
                .authorizeRequests()
                    .antMatchers("/","/home","/homeSign").permitAll()
//                  the "/" and "/home" paths are configured to not require any authentication
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
//                    There is a custom "/login" page specified by loginPage(), and everyone is allowed to view it.
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();

    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

        UserDetails user1 =
                User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,user1);
//        https://docs.spring.io/spring-security/site/docs/current/reference/html/jc.html
    }

//    http://www.mkyong.com/spring-boot/spring-boot-spring-security-thymeleaf-example/
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("user").roles("USER")
//                .and()
//                .withUser("admin").password("admin").roles("ADMIN");
//    }
}
