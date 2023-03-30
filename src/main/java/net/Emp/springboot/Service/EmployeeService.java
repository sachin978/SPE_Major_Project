package net.Emp.springboot.Service;

import net.Emp.springboot.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmp();

    Employee createEmp(Employee employee);

    ResponseEntity<Employee> getEmpbyID(long id);

    ResponseEntity<Employee> updateEmp(long id, Employee employeeDetails);
}
