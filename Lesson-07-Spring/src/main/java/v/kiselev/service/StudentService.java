package v.kiselev.service;

import v.kiselev.Dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDto> findAll();

    Optional<StudentDto> findById(long id);

    StudentDto save(StudentDto student);

    void delete(long id);

}
