package mBean;
import java.util.Arrays;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.json.JsonArray;

import org.primefaces.json.JSONArray;

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
	public String doVerifyWord(String word)
	{
		JSONArray ja = new JSONArray(Arrays.asList(word));
		return ja.toString();		
	}

}
