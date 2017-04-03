package comp.cap.db;

import java.util.List;
import com.cap.domain.User;

public interface UserDAO {
	
	List<User> getUsers();
	User getUser(String email);
	void updateUser(User user);
	void deleteUSer(User user);
	void addUser(User user);
	
}
