package lk.ijse.dep10.EmpManagement.controller;

import lk.ijse.dep10.EmpManagement.model.Employee;
import lk.ijse.dep10.EmpManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
@CrossOrigin

public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<String> saveEmployee(@RequestBody @Valid Employee employee){
        return  employeeService.saveEmployee(employee);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        employeeService.deleteEmployeeById(employeeId);

    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") Integer employeeId,
                               @RequestBody @Valid Employee employee) throws Exception {
        employee.setId(employeeId);
        employeeService.updateEmployee(employee);
    }
    @GetMapping
    public List<Employee> getEmployee(@RequestParam(value = "q", required = false) String query) {
        return employeeService.findEmployees(query);
    }

}
