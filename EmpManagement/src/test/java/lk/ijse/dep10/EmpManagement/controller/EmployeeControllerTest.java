package lk.ijse.dep10.EmpManagement.controller;

import static org.junit.jupiter.api.Assertions.*;

import lk.ijse.dep10.EmpManagement.controller.EmployeeController;
import lk.ijse.dep10.EmpManagement.model.Employee;
import lk.ijse.dep10.EmpManagement.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @Test
    public void saveEmployeeTest() {
        Employee employee = new Employee(1, "John", "Doe", "johndoe@example.com");
        ResponseEntity<String> expectedResponse = new ResponseEntity<>("Employee saved successfully", HttpStatus.CREATED);

        when(employeeService.saveEmployee(employee)).thenReturn(expectedResponse);

        ResponseEntity<String> actualResponse = employeeController.saveEmployee(employee);

        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody(), actualResponse.getBody());

        verify(employeeService, times(1)).saveEmployee(employee);
    }

    @Test
    public void deleteEmployeeTest() {
        int employeeId = 1;

        employeeController.deleteEmployee(employeeId);

        verify(employeeService, times(1)).deleteEmployeeById(employeeId);
    }

    @Test
    public void updateEmployeeTest() throws Exception {
        Employee employee = new Employee(1, "John", "Doe", "johndoe@example.com");

        employeeController.updateEmployee(employee.getId(), employee);

        verify(employeeService, times(1)).updateEmployee(employee);
    }

    @Test
    public void getEmployeeTest() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "John", "Doe", "johndoe@example.com"));

        when(employeeService.findEmployees(null)).thenReturn(employeeList);

        List<Employee> actualList = employeeController.getEmployee(null);

        assertNotNull(actualList);
        assertEquals(employeeList.size(), actualList.size());

        verify(employeeService, times(1)).findEmployees(null);
    }

    @Test
    public void getEmployeeTestWithQuery() {
        String query = "John";
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "John", "Doe", "johndoe@example.com"));

        when(employeeService.findEmployees(query)).thenReturn(employeeList);

        List<Employee> actualList = employeeController.getEmployee(query);

        assertNotNull(actualList);
        assertEquals(employeeList.size(), actualList.size());

        verify(employeeService, times(1)).findEmployees(query);
    }
}
