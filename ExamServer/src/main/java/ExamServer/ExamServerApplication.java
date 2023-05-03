package ExamServer;

import java.util.HashSet;
import java.util.Set;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ExamServer.model.User;
import ExamServer.model.UserRole;
import ExamServer.service.UserService;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting Code");
		User user = new User();
		user.setFirstName("Prateek");
		user.setLastName("Tiwari");
		user.setUsername("durgesh8896");
		user.setPassword("abc");
		user.setEmail("abc@gmail.com");
		
		
		Role role1=new Role(null, null);
		
		role1.setRoleName("ADMIN");
		
		Set<UserRole> userRoleSet=new HashSet<>();
		UserRole userRole = new UserRole();
		
		userRole.setUser(user);
		
		userRoleSet.add(userRole);
		User user1=this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());
		
	}

	
}
