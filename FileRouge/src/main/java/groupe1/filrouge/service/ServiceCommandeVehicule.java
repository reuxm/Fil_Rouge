package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe1.filrouge.dao.CommandeVehiculeDao;
import groupe1.filrouge.entity.CommandeVehicule;

@Service
public class ServiceCommandeVehicule implements IServiceCommandeVehicule {

	@Autowired
	private CommandeVehiculeDao dao;
	
	@Override
	public List<CommandeVehicule> list() {
		return dao.findAll();
	}

	@Override
	public CommandeVehicule find(Integer id) {
		return dao.findById( id ).get();
	}

	@Override
	public void create(CommandeVehicule c) {
		dao.save( c );
	}

	@Override
	public void update(CommandeVehicule c) {
		dao.save( c );
	}

	@Override
	public void delete(CommandeVehicule c) {
		dao.deleteById( c.getId() );
	}

}
