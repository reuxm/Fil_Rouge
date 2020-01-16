package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import groupe1.filrouge.dao.VehiculeDao;
import groupe1.filrouge.entity.Vehicule;


@Service
public class ServiceVehicule implements IServiceVehicule {

	@Autowired
	VehiculeDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Vehicule> rechercheVehicule() {
		return dao.findAll();
	}
	
	@Transactional(readOnly=true)
	@Override
	public Vehicule rechercheVehiculeId(int id) {
		return dao.findById(id).get();
		
	}
	@Transactional
	@Override
	public void creerVehicule(Vehicule vehicule) {
		dao.save(vehicule);

	}
	@Transactional
	@Override
	public void modifierVehicule(Vehicule vehicule) {
		dao.save(vehicule);

	}

	@Override
	public void supprimerVehicule(Vehicule vehicule) {
		dao.deleteById(vehicule.getId());
	}

}
