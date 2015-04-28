package services.implementation;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Mots;
import domain.User;
import services.interfaces.MotsManagementServicesLocal;
@Stateless
public class MotsManagementServices implements MotsManagementServicesLocal {

	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public String sayAhla(String name) {
		
		return "Ahla "+name ;
	}

	@Override
	public Mots FindMot(String mot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mots> GetAllMots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRandom() {
		String jpql = "from Mots ORDER BY RAND()";
		Query query = entityManager.createQuery(jpql);
		try {
			query.setMaxResults(1);
			return ((Mots) query.getSingleResult()).getLibelle();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
