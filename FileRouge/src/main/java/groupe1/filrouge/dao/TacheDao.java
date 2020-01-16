package groupe1.filrouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import groupe1.filrouge.entity.Tache;

public interface TacheDao extends JpaRepository<Tache, Integer> {

}
