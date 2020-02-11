package groupe1.filrouge.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import groupe1.filrouge.entity.User;


public interface DaoUserDetail extends JpaRepository<User,Integer> {
	
	@Query("Select u From User u where u.login = ?1")
	User loadUserByUsername(String nom);
}
