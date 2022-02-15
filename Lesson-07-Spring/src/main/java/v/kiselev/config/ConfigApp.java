package v.kiselev.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import v.kiselev.entity.Student;
import v.kiselev.entity.StudentRepository;

@Configuration
@Slf4j
public class ConfigApp {
    @Bean
    public CommandLineRunner loadService(StudentRepository studentRepository) {
        return args -> {
            log.info("Start load data");
            log.info("Data = {}",studentRepository.save(new Student("Ivanov", 22)));
            log.info("Data = {}",studentRepository.save(new Student("Petrov", 21)));
            log.info("Data = {}",studentRepository.save(new Student("Sidorov", 23)));

            log.info("data was loaded");
        };
    }
}
