package domain;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity

public class User implements Serializable {

	   
	@Id
	private Integer id;
	private String name;
	private String login;
	private String password;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	
	public User(Integer id, String name, String login, String password) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
	}
	public User(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.login = user.getLogin();
		this.password = user.getPassword();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer Id) {
		this.id = Id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String Name) {
		this.name = Name;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String Login) {
		this.login = Login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String Password) {
		this.password = Password;
	}
   
}
