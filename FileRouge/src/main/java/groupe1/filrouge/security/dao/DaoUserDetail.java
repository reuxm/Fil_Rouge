package groupe1.filrouge.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import groupe1.filrouge.entity.User;
import groupe1.filrouge.security.entity.UserDet;


public interface DaoUserDetail extends JpaRepository<User,Integer> {
	
	@Query("Select u From UserDet u where u.login = ?1")
	UserDet loadUserByUsername(String nom);
}
