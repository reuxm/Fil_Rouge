package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.FactureFiche;

public interface IServiceFactureFiche {

	List<FactureFiche> list();
	FactureFiche find( Integer id );
	void create( FactureFiche f );
	void update( FactureFiche f );
	void delete( FactureFiche f );

}
