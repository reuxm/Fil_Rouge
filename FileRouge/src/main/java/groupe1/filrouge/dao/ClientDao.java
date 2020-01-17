package groupe1.filrouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import groupe1.filrouge.entity.Client;

public interface ClientDao extends JpaRepository<Client, Integer>{
}
