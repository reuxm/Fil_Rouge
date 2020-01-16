package groupe1.filrouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import groupe1.filrouge.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
