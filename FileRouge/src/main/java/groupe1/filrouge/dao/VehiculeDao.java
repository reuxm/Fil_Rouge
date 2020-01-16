package groupe1.filrouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import groupe1.filrouge.entity.Vehicule;

public interface VehiculeDao extends JpaRepository<Vehicule, Integer> {

}
