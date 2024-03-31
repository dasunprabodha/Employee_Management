package lk.ijse.dep10.EmpManagement.service;

import lk.ijse.dep10.EmpManagement.dao.EmployeeDao;
import lk.ijse.dep10.EmpManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public ResponseEntity<String> saveEmployee(Employee employee) {
    employeeDao.save(employee);
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }

    public void deleteEmployeeById(Integer employeeId) {
        employeeDao.deleteById(employeeId);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    public List<Employee> findEmployees(String query) {
        return employeeDao.findAll();
    }
}
