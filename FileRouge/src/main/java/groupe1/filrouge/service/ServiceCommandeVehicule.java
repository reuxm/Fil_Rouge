package groupe1.filrouge.service;

import java.util.ArrayList;
import java.util.Calendar;
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

	@Override
	@Transactional
	public List<CommandeVehicule> listVeille() {
		List<CommandeVehicule> listeCommandes = dao.findAll();
		List<CommandeVehicule> listeCommandesVeille = new ArrayList<CommandeVehicule>();
		for(CommandeVehicule commande:listeCommandes) {
			Calendar c1 = Calendar.getInstance(); 
			c1.add(Calendar.DAY_OF_YEAR, -1); 
			Calendar c2 = Calendar.getInstance();
			c2.setTime(commande.getDateCreation()); 
			if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)
			  && c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR)) {
				listeCommandesVeille.add(commande);
			}
		}
		return listeCommandesVeille;
	}

}
