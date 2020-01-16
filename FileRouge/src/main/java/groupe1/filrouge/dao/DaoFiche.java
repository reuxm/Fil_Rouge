package groupe1.filrouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import groupe1.filrouge.entity.Fiche;

public interface DaoFiche extends JpaRepository<Fiche, Integer> {

}
