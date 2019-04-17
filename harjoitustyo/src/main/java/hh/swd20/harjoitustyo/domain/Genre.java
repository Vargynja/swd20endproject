package hh.swd20.harjoitustyo.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "genreid", nullable = false)
	@Setter(AccessLevel.NONE)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@JsonIgnore
	@ManyToMany
	private Set<Game> games;

}
