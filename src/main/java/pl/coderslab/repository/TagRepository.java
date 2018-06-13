package pl.coderslab.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
	Tag findTagById (Long id);
}
