package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe1.filrouge.dao.DevisDao;
import groupe1.filrouge.entity.Devis;

@Service
public class ServiceDevis implements IServiceDevis {

	@Autowired
	private DevisDao dao;
	
	@Override
	public List<Devis> list() {
		return dao.findAll();
	}

	@Override
	public Devis find(Integer id) {
		return dao.findById( id ).get();
	}

	@Override
	public void create(Devis d) {
		dao.save( d );
	}

	@Override
	public void update(Devis d) {
		dao.save( d );
	}

	@Override
	public void delete(Devis d) {
		dao.deleteById( d.getId() );
	}

}
