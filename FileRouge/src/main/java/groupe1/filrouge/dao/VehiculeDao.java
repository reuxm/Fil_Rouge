package groupe1.filrouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import groupe1.filrouge.entity.Vehicule;

@RepositoryRestResource
public interface VehiculeDao extends JpaRepository<Vehicule, Integer> , JpaSpecificationExecutor<Vehicule>{

}
