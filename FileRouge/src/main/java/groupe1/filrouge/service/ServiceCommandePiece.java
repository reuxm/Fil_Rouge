package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import groupe1.filrouge.dao.CommandePieceDao;
import groupe1.filrouge.entity.CommandePiece;

@Service
public class ServiceCommandePiece implements IServiceCommandePiece {

	@Autowired
	private CommandePieceDao dao;
	
	@Override
	@Transactional(readOnly=true)
	public List<CommandePiece> list() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public CommandePiece find(Integer id) {
		return dao.findById( id ).get();
	}

	@Override
	@Transactional
	public void create(CommandePiece c) {
		dao.save( c );
	}

	@Override
	@Transactional
	public void update(CommandePiece c) {
		dao.save( c );
	}

	@Override
	@Transactional
	public void delete(CommandePiece c) {
		dao.deleteById( c.getId() );
	}

}
