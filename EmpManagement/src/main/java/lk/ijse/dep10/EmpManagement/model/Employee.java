package lk.ijse.dep10.EmpManagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name ="Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name can't be empty or null")
    @Pattern(regexp = "[A-Za-z ]+", message = "Invalid name")
    private String firstName;

    @NotBlank(message = "Name can't be empty or null")
    @Pattern(regexp = "[A-Za-z ]+", message = "Invalid name")
    private String lastName;
    @NotBlank(message = "email can't be empty or null")
    @Length(min = 3, message = "Invalid email")
    private String email;

}
