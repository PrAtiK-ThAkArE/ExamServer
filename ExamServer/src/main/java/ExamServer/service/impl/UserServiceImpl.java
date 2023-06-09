 package ExamServer.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ExamServer.model.Role;
import ExamServer.model.User;
import ExamServer.model.UserRole;
import ExamServer.repo.RoleRepository;
import ExamServer.repo.UserRepository;
import ExamServer.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	//creating User
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		User local=this.userRepository.findByUsername(user.getUsername());
		if(local!=null) {
			System.out.println("User is already there");
			
			throw new Exception("User already present");
		}else
		{
			for(UserRole ur:userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(user);
		}
		return local ;
	}
	

}
