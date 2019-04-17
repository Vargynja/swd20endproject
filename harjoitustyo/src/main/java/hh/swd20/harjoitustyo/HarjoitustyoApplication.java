package hh.swd20.harjoitustyo;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.harjoitustyo.domain.*;


@SpringBootApplication
public class HarjoitustyoApplication {

	private static final Logger log = LoggerFactory.getLogger(HarjoitustyoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(HarjoitustyoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UserRepository userrepo, GameRepository gamerepo,
			GenreRepository genrerepo, CommentRepository commentrepo) {
		return(args) -> {
			log.info("Create 2 users");
			User user1 = new User();
			user1.setUsername("admin"); user1.setPasswordHash("$2a$10$FkneFIYR6qF/zTFy6Iq1jOMXlApALF9/LMbuNxA85J0zk6gF4cgEq");
			user1.setRole("ADMIN"); user1.setEmail("admin@gamestatics.com");
			userrepo.save(user1);
			User user2 = new User();
			user2.setUsername("user"); user2.setPasswordHash("$2a$10$LTSKPt1JXGE5XSF5HQnHa.Gvj4T6IGms4B3sF3KUA7hrfo8jLKjoe");
			user2.setRole("USER"); user2.setEmail("somguta@gajt.com");
			userrepo.save(user2);
			
			log.info("Create genres");
			Genre genre1 = new Genre(); genre1.setName("RPG");
			Genre genre2 = new Genre(); genre2.setName("FPS");
			Genre genre3 = new Genre(); genre3.setName("Strategy");
			Genre genre4 = new Genre(); genre4.setName("Simulator");
			Genre genre5 = new Genre(); genre5.setName("Action");
			genrerepo.save(genre1); genrerepo.save(genre2); genrerepo.save(genre3);
			genrerepo.save(genre4); genrerepo.save(genre5);
			
			log.info("Add games");
			Game game1 = new Game(); game1.setTitle("Skyrim"); game1.setSummary("Somethin somthin rpg.");
			Set<Genre> set = new HashSet<>(); set.addAll(genrerepo.findByName("RPG")); game1.setReview("Dope game!");
			game1.setGenres(set); gamerepo.save(game1);
			Game game2 = new Game(); game2.setTitle("Everything in Genres"); game2.setSummary("Test for genres");
			set.clear(); game2.setReview("");
			for (Genre genre : genrerepo.findAll()) {
				set.add(genre);
			}
			game2.setGenres(set); gamerepo.save(game2);
			
			log.info("Creating comments");
			Comment comment1 = new Comment(); comment1.setComment("gnaklhgbghbgkabkabgbagkbgakb");
			comment1.setGame(gamerepo.findByTitle("Skyrim").get(0));
			comment1.setUser(userrepo.findByUsername("admin")); commentrepo.save(comment1);
			Comment comment2 = new Comment(); comment2.setComment("gnaklhgbgahhaghbgkabkabgbagkbgakb");
			comment2.setGame(gamerepo.findByTitle("Everything in Genres").get(0));
			comment1.setUser(userrepo.findByUsername("admin")); commentrepo.save(comment2);
			
			Comment comment3 = new Comment(); comment3.setComment("gnaklhgbghbgkabkabgbagkbgakb");
			comment3.setGame(gamerepo.findByTitle("Skyrim").get(0));
			comment3.setUser(userrepo.findByUsername("user")); commentrepo.save(comment3);
			Comment comment4 = new Comment(); comment4.setComment("gnakagharnhalhgbghbgkabkabgbagkbgakb");
			comment4.setGame(gamerepo.findByTitle("Skyrim").get(0));
			comment4.setUser(userrepo.findByUsername("user")); commentrepo.save(comment4);
		};
	}
}
