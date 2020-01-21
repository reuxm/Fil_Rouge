package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.FactureDevis;

public interface IServiceFactureDevis {

	List<FactureDevis> list();
	FactureDevis find( Integer id );
	void create( FactureDevis f );
	void update( FactureDevis f );
	void delete( FactureDevis f );

}
