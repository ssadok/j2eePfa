package services.interfaces;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import domain.Mots;
@Remote
public interface MotsManagementServicesLocal {
	
	 String sayAhla(String name);
	 Mots FindMot(String mot);
	 List<Mots> GetAllMots();
	 String getRandom();
	

}
