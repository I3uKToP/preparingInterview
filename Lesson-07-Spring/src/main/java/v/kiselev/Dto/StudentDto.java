package v.kiselev.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentDto {

    private  Long id;

    private String name;

    private Integer age;

}
