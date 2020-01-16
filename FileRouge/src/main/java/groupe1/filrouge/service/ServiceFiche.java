package groupe1.filrouge.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe1.filrouge.dao.DaoFiche;
import groupe1.filrouge.entity.Fiche;

@Service
public class ServiceFiche implements IServiceFiche {

	@Autowired
	private DaoFiche daofiche;

	@Transactional
	@Override
	public List<Fiche> rechercheFiche() {
		// TODO Auto-generated method stub
		return daofiche.findAll();
	}

	@Transactional
	@Override
	public Fiche rechercheFicheId(int id) {
		// TODO Auto-generated method stub
		return daofiche.findById(id).get();
	}

	@Override
	public void creerFiche(Fiche pfiche) {
		// TODO Auto-generated method stub
		daofiche.save(pfiche);

	}

	@Transactional
	@Override
	public void modifierFiche(Fiche pfiche) {
		// TODO Auto-generated method stub
		daofiche.save(pfiche);

	}

	@Transactional
	@Override
	public void supprimerFiche(Fiche pfiche) {
		// TODO Auto-generated method stub
		daofiche.deleteById(pfiche.getId());

	}

}
