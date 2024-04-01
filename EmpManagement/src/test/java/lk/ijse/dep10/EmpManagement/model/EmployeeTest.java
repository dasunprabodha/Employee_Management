package lk.ijse.dep10.EmpManagement.model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lk.ijse.dep10.EmpManagement.model.Employee;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void testValidEmployee() {
        Employee employee = new Employee(null, "John", "Doe", "johndoe@example.com");

        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
        assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void testEmptyFirstName() {
        Employee employee = new Employee(null, "", "Doe", "johndoe@example.com");

        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
        assertEquals(1, constraintViolations.size());
        assertEquals("Name can't be empty or null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidFirstNameCharacters() {
        Employee employee = new Employee(null, "John!", "Doe", "johndoe@example.com");

        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
        assertEquals(1, constraintViolations.size());
        assertEquals("Invalid name", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testEmptyLastName() {
        Employee employee = new Employee(null, "John", "", "johndoe@example.com");

        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
        assertEquals(1, constraintViolations.size());
        assertEquals("Name can't be empty or null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidLastNameCharacters() {
        Employee employee = new Employee(null, "John", "Doe123", "johndoe@example.com");

        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
        assertEquals(1, constraintViolations.size());
        assertEquals("Invalid name", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testEmptyEmail() {
        Employee employee = new Employee(null, "John", "Doe", "");

        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
        assertEquals(1, constraintViolations.size());
        assertEquals("email can't be empty or null", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidEmail() {
        Employee employee = new Employee(null, "John", "Doe", "invalidEmail");

        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
        assertEquals(1, constraintViolations.size());
        assertEquals("Invalid email", constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void testShortEmail() {
        Employee employee = new Employee(null, "John", "Doe", "jd@ex.com");

        Set<ConstraintViolation<Employee>> constraintViolations = validator.validate(employee);
        assertEquals(1, constraintViolations.size());
        assertEquals("Invalid email", constraintViolations.iterator().next().getMessage());
    }
}
