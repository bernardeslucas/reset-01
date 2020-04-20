package br.com.cwi.tinderevolution;

import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.music.MusicGenres;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.management.MusicManagement;
import br.com.cwi.tinderevolution.management.SportManagement;
import br.com.cwi.tinderevolution.management.UserManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TinderEvolutionApplication {

	public static void main(String[] args) {
		 UserManagement userManagement = new UserManagement();
		 MusicManagement musicManagement = new MusicManagement();
		 SportManagement sportManagement = new SportManagement();

		userManagement.list().add(new User(1, "lucas", "lucas@gmail.com", "51982895322",
				LocalDate.of(1995,9,4), "uhul", 10.0, 10.0, "imgur.com/aslkda.png"));
		userManagement.list().add(new User(2, "juliana", "juliana@gmail.com", "51982895322",
				LocalDate.of(1995,9,4), "uhul", 10.0, 10.0, "imgur.com/aslkda.png"));
		userManagement.list().add(new User(3, "GUSTAVO", "gustavo@gmail.com", "51982895322",
				LocalDate.of(1995,9,4), "uhul", 10.0, 10.0, "imgur.com/aslkda.png"));


		musicManagement.list().add(new Music(1,"nossa musica", "aqueles artistas", LocalDate.now(), MusicGenres.SERTANEJO));
		musicManagement.list().add(new Music(2, "a1231 musica", "aqueles artistas", LocalDate.now(), MusicGenres.SERTANEJO));
		musicManagement.list().add(new Music(3, "4444444444 musica", "aqueles artistas", LocalDate.now(), MusicGenres.SERTANEJO));

		SpringApplication.run(TinderEvolutionApplication.class, args);
	}

}
