package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.Client;

public interface IServiceClient {

	List<Client> list();
	Client find( Integer id );
	void create( Client c );
	void update( Client c );
	void delete( Client c );
	
}
