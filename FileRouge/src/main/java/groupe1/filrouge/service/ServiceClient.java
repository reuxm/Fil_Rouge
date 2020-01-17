package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import groupe1.filrouge.dao.ClientDao;
import groupe1.filrouge.entity.Client;

@Service
public class ServiceClient implements IServiceClient {

	@Autowired
	private ClientDao dao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Client> list() {
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Client find(Integer id) {
		return dao.findById( id ).get();
	}

	@Override
	@Transactional
	public void create(Client c) {
		dao.save( c );
	}

	@Override
	@Transactional
	public void update(Client c) {
		dao.save( c );
	}

	@Override
	@Transactional
	public void delete(Client c) {
		dao.deleteById(c.getId());
	}

}
