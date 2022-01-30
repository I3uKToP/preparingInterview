package v.kiselev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import v.kiselev.persist.StudentDao;

import javax.persistence.EntityManagerFactory;

@Configuration
public class AppConfig {

    EntityManagerFactory emFactory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
            .buildSessionFactory();

    @Bean
    public StudentDao studentDao() {
        return new StudentDao(emFactory);
    }
}
