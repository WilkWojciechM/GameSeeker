package pl.coderslab.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entity.Game;
import pl.coderslab.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
		@Query("SELECT u.ugames FROM User u WHERE u.id=:id")
		List<Game> getUserGames(@Param("id") Long id);
		
		User findUserById(Long id);
		User findByLogin(String login);
		User findByEmail(String email);
}
