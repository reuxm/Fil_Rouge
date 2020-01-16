package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.Devis;

public interface IServiceDevis {

	List<Devis> list();
	Devis find( Integer id );
	void create( Devis d );
	void update( Devis d );
	void delete( Devis d );

}
