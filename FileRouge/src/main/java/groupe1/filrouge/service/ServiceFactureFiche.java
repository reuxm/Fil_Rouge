package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import groupe1.filrouge.dao.FactureFicheDao;
import groupe1.filrouge.entity.FactureFiche;

@Service
public class ServiceFactureFiche implements IServiceFactureFiche {

	@Autowired
	private FactureFicheDao dao;
	
	@Override
	public List<FactureFiche> list() {
		return dao.findAll();
	}

	@Override
	public FactureFiche find(Integer id) {
		return dao.findById( id ).get();
	}

	@Override
	public void create(FactureFiche f) {
		dao.save( f );
	}

	@Override
	public void update(FactureFiche f) {
		dao.save( f );
	}

	@Override
	public void delete(FactureFiche f) {
		dao.deleteById( f.getId() );
	}

}
