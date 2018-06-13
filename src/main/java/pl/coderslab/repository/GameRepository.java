package pl.coderslab.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.entity.Game;
import pl.coderslab.entity.Tag;


public interface GameRepository extends JpaRepository<Game, Long> {
	Game findGameById (Long id);
	@Query("SELECT g.tags FROM Game g WHERE g.id=:id")
	List<Tag> getGameTags(@Param("id") Long id);
}
