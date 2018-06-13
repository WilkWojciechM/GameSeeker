package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.User;

@Component
@Transactional
public class UserDao {

	@PersistenceContext
	EntityManager em;

	public void save(User entity) {
		this.em.persist(entity);
	}

	public void update(User entity) {
		this.em.merge(entity);
	}

	public User findById(long id) {
		return this.em.find(User.class, id);
	}

	public void delete(User entity) {
		this.em.remove(this.em.contains(entity) ? entity : this.em.merge(entity));
	}

	public List<User> getAll() {
		Query query = this.em.createQuery("SELECT e FROM User e");
		return query.getResultList();
	}
}
