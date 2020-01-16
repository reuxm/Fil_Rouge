package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import groupe1.filrouge.dao.ProfilDao;
import groupe1.filrouge.entity.Profil;

@Service
public class ServiceProfil implements IServiceProfil {
	@Autowired
	ProfilDao dao;

	@Transactional
	@Override
	public List<Profil> rechercheProfil() {
		return dao.findAll();
	}

	@Transactional
	@Override
	public Profil rechercheProfilId(int id) {
		return dao.findById(id).get();
	}

	@Transactional
	@Override
	public void creerProfil(Profil pProfil) {
		dao.save(pProfil);
	}
	
	@Transactional
	@Override
	public void modifierProfil(Profil pProfil) {
		dao.save(pProfil);
	}

	@Transactional
	@Override
	public void supprimerProfil(Profil pProfil) {
		dao.deleteById(pProfil.getId());
	}

}
