package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.CommandePiece;

public interface IServiceCommandePiece {

	List<CommandePiece> list();
	CommandePiece find( Integer id );
	void create( CommandePiece c );
	void update( CommandePiece c );
	void delete( CommandePiece c );

}
