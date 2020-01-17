package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe1.filrouge.dao.FactureDevisDao;
import groupe1.filrouge.entity.FactureDevis;

@Service
public class ServiceFactureDevis implements IServiceFactureDevis {

	@Autowired
	private FactureDevisDao dao;
	
	@Override
	public List<FactureDevis> list() {
		return dao.findAll();
	}

	@Override
	public FactureDevis find(Integer id) {
		return dao.findById( id ).get();
	}

	@Override
	public void create(FactureDevis f) {
		dao.save( f );
	}

	@Override
	public void update(FactureDevis f) {
		dao.save( f );
	}

	@Override
	public void delete(FactureDevis f) {
		dao.deleteById( f.getId() );
	}

}
