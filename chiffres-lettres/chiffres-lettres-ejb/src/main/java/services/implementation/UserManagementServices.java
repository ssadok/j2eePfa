package services.implementation;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.User;
import services.interfaces.UserManagementServicesLocal;
import services.interfaces.UserManagementServicesRemote;

@Stateless
@LocalBean
public class UserManagementServices implements UserManagementServicesRemote,UserManagementServicesLocal{

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserManagementServices() {
		// TODO Auto-generated constructor stub
	}


	public User login(String login, String password) {
		User user = null;
		String jpql = "select u from User u where u.login =:param1 and u.password =:param2 ";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("user not found ");
		}
		return user;

	}

}
