package hh.swd20.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Long id;
	
	@NotNull
	private String title;
	
	@Max(2000)
	private String summary;
	private String review;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
	@JsonIgnore
	private List<Comment> comments;
	
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
