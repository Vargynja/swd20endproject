package hh.swd20.harjoitustyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "genreid", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String genre;
	
	public Genre() {}

	public Genre(String genre) {
		super();
		this.genre = genre;
	}
}
