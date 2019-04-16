package hh.swd20.harjoitustyo;

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
		};
	}
}
