package mBean;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import services.interfaces.MotsManagementServicesLocal;
import word.MyWord;
@ManagedBean (name = "Mb")
public class MotsManagementBean {
	@EJB
	private MotsManagementServicesLocal motsManagementServicesLocal;
	MyWord myWord;
	public String getRandom() {
		try
		{
			myWord = new MyWord(motsManagementServicesLocal.getRandom());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
//			e.printStackTrace();
			return "";
		}
		return myWord.getFirstChar();
	}


}
