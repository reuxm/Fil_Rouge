package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.User;

public interface IServiceUser {

	public List<User> rechercheUser();
	public User rechercheUserId(final int id);
	public void creerUser(final User user);
	public void modifierUser(final User user);
	public void supprimerUser(final User user);
	}