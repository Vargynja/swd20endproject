package hh.swd20.harjoitustyo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	private String summary;
	private String review;
	
	public Game() {}
	
	public Game(String title, String summary, String review) {
		this.title = title;
		this.summary = summary;
		this.review = review;
	}


	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSummary() {
		return summary;
	}
	
	public String getReview() {
		return review;
	}
}
