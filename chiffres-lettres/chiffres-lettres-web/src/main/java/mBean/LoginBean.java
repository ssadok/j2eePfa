package mBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import services.interfaces.*;
import domain.Player;
import domain.User;

@ManagedBean(name = "lb")
@SessionScoped
public class LoginBean {
	private User user = new User();
	@EJB
	private UserManagementServicesLocal userManagementServicesLocal;

	public String doLogin() {
		User userFounded = userManagementServicesLocal.login(user.getLogin(),
				user.getPassword());
		if (userFounded != null) {
			user = userFounded;
			if (userFounded instanceof Player) {
				return "/pages/mainRoom";
			} else {
				return "";
			}

		} else {
			return "/error";
		}

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
	