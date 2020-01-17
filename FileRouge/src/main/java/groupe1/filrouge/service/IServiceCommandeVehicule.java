package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.CommandeVehicule;

public interface IServiceCommandeVehicule {

	List<CommandeVehicule> list();
	CommandeVehicule find( Integer id );
	void create( CommandeVehicule c );
	void update( CommandeVehicule c );
	void delete( CommandeVehicule c );

}
