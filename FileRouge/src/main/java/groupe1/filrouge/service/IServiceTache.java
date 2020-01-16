package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.Tache;

public interface IServiceTache {

	public List<Tache> rechercheTache();
	public Tache rechercheTacheId(final int id);
	public void creerTache(final Tache tache);
	public void modifierTache(final Tache tache);
	public void supprimerTache(final Tache tache);
	}