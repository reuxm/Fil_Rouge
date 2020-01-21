package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import groupe1.filrouge.dao.PrioriteDao;
import groupe1.filrouge.entity.Priorite;

@Service
public class ServicePriorite implements IServicePriorite {
	@Autowired
	PrioriteDao dao;

	@Transactional(readOnly = true)
	@Override
	public List<Priorite> recherchePriorite() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Priorite recherchePrioriteId(int id) {
		return dao.findById(id).get();
	}

	@Transactional
	@Override
	public void creerPriorite(Priorite pPriorite) {
		dao.save(pPriorite);
	}

	@Transactional
	@Override
	public void modifierPriorite(Priorite pPriorite) {
		dao.save(pPriorite);
	}

	@Transactional
	@Override
	public void supprimerPriorite(Priorite pPriorite) {
		/*dao.deleteById(pPriorite.getId());*/
	}

}
