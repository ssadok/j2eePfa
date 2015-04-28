package services.implementation;

import java.nio.file.FileStore;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.*;

/**
 * Session Bean implementation class DbCreator
 */
@Singleton
@Startup
public class DbCreator {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public DbCreator() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {


		/*Mots mot = new Mots(1, "Salut");
		Mots mot2 = new Mots(2,"Bonjour");
		Mots mot3 = new Mots(3,"Hello");*/
		
		User user = new User(1,"khalil","khalilos", "0000");
		User user2 = new User(2,"charfeddin","charf", "0000");
		User user3 = new User(3,"charfeddin","charf", "0000");
		User user4 = new User(4,"sadok","saddem", "abcd");
		Player player= new Player(user2,0,0);
		Player player2= new Player(user4,0,0);


		/*entityManager.persist(mot);
		entityManager.persist(mot2);
		entityManager.persist(mot3);*/
		
		entityManager.persist(user);
		entityManager.persist(user3);
		entityManager.persist(player);
		entityManager.persist(player2);
	}
}
