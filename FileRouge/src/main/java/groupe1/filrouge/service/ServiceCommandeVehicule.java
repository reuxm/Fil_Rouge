package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import groupe1.filrouge.dao.CommandeVehiculeDao;
import groupe1.filrouge.entity.CommandeVehicule;

@Service
public class ServiceCommandeVehicule implements IServiceCommandeVehicule {

	@Autowired
	private CommandeVehiculeDao dao;
	
	@Override
	@Transactional(readOnly=true)
	public List<CommandeVehicule> list() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public CommandeVehicule find(Integer id) {
		return dao.findById( id ).get();
	}

	@Override
	@Transactional
	public void create(CommandeVehicule c) {
		dao.save( c );
	}

	@Override
	@Transactional
	public void update(CommandeVehicule c) {
		dao.save( c );
	}

	@Override
	@Transactional
	public void delete(CommandeVehicule c) {
		dao.deleteById( c.getId() );
	}

}
