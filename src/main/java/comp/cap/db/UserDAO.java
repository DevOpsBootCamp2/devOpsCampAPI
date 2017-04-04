package comp.cap.db;

import java.util.List;
import com.cap.domain.User;

public interface UserDAO {
	
	public List<User> getUsers();
	public User getUser(String email);
	public void updateUser(User user);
	public boolean deleteUser(User user);
	public boolean addUser(User user);
	
}
