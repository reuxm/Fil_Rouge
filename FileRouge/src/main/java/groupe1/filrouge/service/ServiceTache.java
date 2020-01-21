package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import groupe1.filrouge.dao.TacheDao;
import groupe1.filrouge.entity.Tache;

@Service
public class ServiceTache implements IServiceTache {

	@Autowired
	TacheDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Tache> rechercheTache() {
		return dao.findAll();
	}
	
	@Transactional(readOnly=true)
	@Override
	public Tache rechercheTacheId(int id) {
		return dao.findById(id).get();
		
	}
	@Transactional
	@Override
	public void creerTache(Tache tache) {
		dao.save(tache);

	}
	@Transactional
	@Override
	public void modifierTache(Tache tache) {
		dao.save(tache);

	}

	@Override
	public void supprimerTache(Tache tache) {
		dao.deleteById(tache.getId());
	}

}
