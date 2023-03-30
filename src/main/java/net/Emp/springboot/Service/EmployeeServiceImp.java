package net.Emp.springboot.Service;

import net.Emp.springboot.repository.EmployeeRepository;
import net.Emp.springboot.exception.ResourceNotFoundException;
import net.Emp.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepo;
    @Override
    public List<Employee> getAllEmp() {

        return employeeRepo.findAll();
    }

    @Override
    public Employee createEmp(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public ResponseEntity<Employee> getEmpbyID(long id) {


        Employee emp = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(emp);
    }

    @Override
    public ResponseEntity<Employee> updateEmp(long id, Employee employeeDetails) {

        Employee updateEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepo.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);



    }

}
