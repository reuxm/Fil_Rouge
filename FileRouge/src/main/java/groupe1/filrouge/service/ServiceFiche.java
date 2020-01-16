package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import groupe1.filrouge.dao.FicheDao;
import groupe1.filrouge.entity.Fiche;

@Service
public class ServiceFiche implements IServiceFiche {
	@Autowired
	FicheDao dao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Fiche> rechercheFiche() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Fiche rechercheFicheId(int id) {
		return dao.findById(id).get();
	}

	@Transactional
	@Override
	public void creerFiche(Fiche pFiche) {
		dao.save(pFiche);
	}

	@Transactional
	@Override
	public void modifierFiche(Fiche pFiche) {
		dao.save(pFiche);
	}

	@Transactional
	@Override
	public void supprimerFiche(Fiche pFiche) {
		dao.deleteById(pFiche.getId());
	}

}
