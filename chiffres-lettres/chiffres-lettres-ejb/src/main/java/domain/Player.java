package domain;

import domain.User;
import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Player
 *
 */
@Entity

public class Player extends User implements Serializable {

	
	private Integer score;
	private Integer bestscore;
	private static final long serialVersionUID = 1L;

	public Player() {
		super();
	}  
	
	public Player(User user,Integer score, Integer bestscore) {
		super(user);
		this.score = score;
		this.bestscore = score;
	}

	public Integer getscore() {
		return this.score;
	}

	public void setscore(Integer score) {
		this.score = score;
	}   
	public Integer getbestscore() {
		return this.bestscore;
	}

	public void setbestscore(Integer bestscore) {
		this.bestscore = bestscore;
	}
   
}
