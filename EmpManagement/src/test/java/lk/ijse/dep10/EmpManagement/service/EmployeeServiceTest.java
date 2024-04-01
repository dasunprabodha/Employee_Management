package lk.ijse.dep10.EmpManagement.service;

import static org.junit.jupiter.api.Assertions.*;

import lk.ijse.dep10.EmpManagement.dao.EmployeeDao;
import lk.ijse.dep10.EmpManagement.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeDao employeeDao;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveEmployee() {
        Employee employee = new Employee();
        when(employeeDao.save(employee)).thenReturn(employee);
        ResponseEntity<String> response = employeeService.saveEmployee(employee);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void deleteEmployeeById() {
        Integer employeeId = 1;
        employeeService.deleteEmployeeById(employeeId);
        verify(employeeDao, times(1)).deleteById(employeeId);
    }

    @Test
    void updateEmployee() {
        Employee employee = new Employee();
        employeeService.updateEmployee(employee);
        verify(employeeDao, times(1)).save(employee);
    }

    @Test
    void findEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee());
        employees.add(new Employee());
        when(employeeDao.findAll()).thenReturn(employees);
        List<Employee> foundEmployees = employeeService.findEmployees("query");
        assertEquals(2, foundEmployees.size());
    }
}
