package ExamServer.service;

import java.util.Set;

import ExamServer.model.User;
import ExamServer.model.UserRole;

public interface UserService {
	public User createUser(User user, Set<UserRole> userRoles) throws Exception;
}
