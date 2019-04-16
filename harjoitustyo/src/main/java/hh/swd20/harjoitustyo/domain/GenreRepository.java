package hh.swd20.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long>{
	List<Genre> findByName(String name);
}
