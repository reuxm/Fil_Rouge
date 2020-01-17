package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.Priorite;

public interface IServicePriorite {
	public List<Priorite> recherchePriorite();
	public Priorite recherchePrioriteId(final int id);
	public void creerPriorite(final Priorite pPriorite);
	public void modifierPriorite(final Priorite pPriorite);
	public void supprimerPriorite(final Priorite pPriorite);
}
