package services.interfaces;

import javax.ejb.Remote;

import domain.User;
@Remote
public interface UserManagementServicesRemote {

	User login(String login, String password);
}
