package br.com.cwi.tinderevolution;

import br.com.cwi.tinderevolution.domain.music.Music;
import br.com.cwi.tinderevolution.domain.music.MusicGenres;
import br.com.cwi.tinderevolution.domain.user.User;
import br.com.cwi.tinderevolution.management.MusicManagement;
import br.com.cwi.tinderevolution.management.UserManagement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TinderEvolutionApplication {
    /**
     * If you want to test the consoleApp version, please use the commit below in the branch:
     * https://github.com/lucasbe1909/reset-01/commit/425a3e2394db0c02a592551417aaf3351283c3f6
     * In the last version of this project I left the console package excluded, because it doesn't work anymore
     * with the new functions that were added in the whole project.
     */
    public static void main(String[] args) {
        //used for application test
//        UserManagement userManagement = new UserManagement();
//        MusicManagement musicManagement = new MusicManagement();
//
//        userManagement.list().add(new User(1, "lucas", "lucas@gmail.com", "51982895322", LocalDate.of(1995, 9, 4), "uhul", -29.825786, -51.156513, "imgur.com/aslkda.png"));
//        userManagement.list().add(new User(2, "juliana", "juliana@gmail.com", "51992875878", LocalDate.of(1990, 5, 14), "uhul", -29.825786, -51.156613, "imgur.com/aslkda.png"));
//        userManagement.list().add(new User(3, "gustavo", "gustavo@gmail.com", "51993571284", LocalDate.of(1945, 12, 2), "uhul", -30.003846, -51.097365, "imgur.com/aslkda.png"));
//
//        musicManagement.list().add(new Music(1, "music 1", "artist 1", LocalDate.now(), MusicGenres.SERTANEJO));
//        musicManagement.list().add(new Music(2, "msuic 2", "artist 2", LocalDate.now(), MusicGenres.SERTANEJO));
//        musicManagement.list().add(new Music(3, "music 3", "artist 3", LocalDate.now(), MusicGenres.SERTANEJO));

        SpringApplication.run(TinderEvolutionApplication.class, args);
    }
}
