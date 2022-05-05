package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentInfo {

    private String name;

    private boolean man;

    private Integer age;

    private Double height;

    private Date birthday;
}
