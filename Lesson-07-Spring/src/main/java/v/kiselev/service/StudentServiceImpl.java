package v.kiselev.service;

import org.springframework.stereotype.Service;
import v.kiselev.Dto.StudentDto;
import v.kiselev.entity.Student;
import v.kiselev.entity.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(student -> new StudentDto(student.getId(),
                        student.getName(),
                        student.getAge()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDto> findById(long id) {
        return studentRepository.findById(id).map(student -> 
                new StudentDto(student.getId(),
                        student.getName(),
                        student.getAge()));
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        Optional<Student> optionalStudent = studentRepository.findById(studentDto.getId());
        Student returnStudent;
        if(optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            returnStudent = studentRepository.save(new Student(
                    student.getId(),
                    studentDto.getName(),
                    studentDto.getAge()
            ));
        } else {
            returnStudent = studentRepository.save(
                    new Student(studentDto.getName(), studentDto.getAge()));
        }
        return new StudentDto(returnStudent.getId(),
                returnStudent.getName(),
                returnStudent.getAge());
    }

    @Override
    public void delete(long id) {
        studentRepository.deleteById(id);
    }
}
