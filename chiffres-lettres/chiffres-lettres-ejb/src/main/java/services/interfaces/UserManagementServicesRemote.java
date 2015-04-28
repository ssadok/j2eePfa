package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import domain.User;
@Remote
public interface UserManagementServicesRemote {

	User login(String login, String password);
}
