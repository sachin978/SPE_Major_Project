package net.Emp.springboot;

import net.Emp.springboot.model.User;
import net.Emp.springboot.repository.EmployeeRepository;
import net.Emp.springboot.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args)
	{
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
    @Autowired
	private UserRepo userRepo;
	@Override
	public void run(String... args) throws Exception {
		User user =new User();
		user.setId(Long.valueOf("1"));
		user.setName("sachin");
		user.setPassword("123456");
		user.setRole("USER");
		userRepo.save(user);

//		employee.setEmailId("ramesh@gmail.com");
//		employeeRepository.save(employee);
//
//		Employee employee1 = new Employee();
//		employee1.setFirstName("John");
//		employee1.setLastName("Cena");
//		employee1.setEmailId("cena@gmail.com");
//		employeeRepository.save(employee1);
	}
}
