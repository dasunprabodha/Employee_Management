package lk.ijse.dep10.EmpManagement.dao;

import lk.ijse.dep10.EmpManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
