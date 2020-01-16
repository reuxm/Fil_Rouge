package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import groupe1.filrouge.dao.UserDao;
import groupe1.filrouge.entity.User;

@Service
public class ServiceUser implements IServiceUser {

	@Autowired
	UserDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<User> rechercheUser() {
		return dao.findAll();
	}
	
	@Transactional(readOnly=true)
	@Override
	public User rechercheUserId(int id) {
		return dao.findById(id).get();
		
	}
	@Transactional
	@Override
	public void creerUser(User user) {
		dao.save(user);

	}
	@Transactional
	@Override
	public void modifierUser(User user) {
		dao.save(user);

	}

	@Override
	public void supprimerUser(User user) {
		dao.deleteById(user.getId());
	}

}
