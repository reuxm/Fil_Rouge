package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe1.filrouge.dao.CommandePieceDao;
import groupe1.filrouge.entity.CommandePiece;

@Service
public class ServiceCommandePiece implements IServiceCommandePiece {

	@Autowired
	private CommandePieceDao dao;
	
	@Override
	public List<CommandePiece> list() {
		return dao.findAll();
	}

	@Override
	public CommandePiece find(Integer id) {
		return dao.findById( id ).get();
	}

	@Override
	public void create(CommandePiece c) {
		dao.save( c );
	}

	@Override
	public void update(CommandePiece c) {
		dao.save( c );
	}

	@Override
	public void delete(CommandePiece c) {
		dao.deleteById( c.getId() );
	}

}
