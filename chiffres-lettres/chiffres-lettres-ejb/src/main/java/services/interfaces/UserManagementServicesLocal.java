package services.interfaces;
import java.util.List;

import javax.ejb.Local;

import domain.User;
@Local
public interface UserManagementServicesLocal {
	User login(String login, String password);

}
