package hh.swd20.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid", nullable = false, updatable = false)
	@Setter(AccessLevel.NONE)
	private Long id;

	@Column(name = "username", nullable = false, unique = true)
	@Size(min = 3, max = 20)
	private String username;

	@JsonIgnore
	@NotNull
	@Column(name = "password", nullable = false)
	private String passwordHash;

	@Column(name = "email", nullable = false)
	private String email;

	@JsonIgnore
	@NotNull
	@Column(name = "role", nullable = false)
	private String role;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Comment> comments;

}
