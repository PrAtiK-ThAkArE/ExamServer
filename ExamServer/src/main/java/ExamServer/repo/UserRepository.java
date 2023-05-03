package ExamServer.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import ExamServer.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	public User findByUsername(String username);
	
}
