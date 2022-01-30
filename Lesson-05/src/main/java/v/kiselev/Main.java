package v.kiselev;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import v.kiselev.config.AppConfig;
import v.kiselev.persist.Student;
import v.kiselev.persist.StudentDao;

import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//
//        for (int i = 0; i < 10000; i++) {
//            Random random = new Random();
//            Student student = new Student();
//            student.setName("Student #" + i);
//            student.setMark(random.nextInt(5));
//            studentDao.saveOrUpdate(student);
//        }
        Optional<Student> student2 = studentDao.findById(2L);
        System.out.println(student2.get());
    }
}
