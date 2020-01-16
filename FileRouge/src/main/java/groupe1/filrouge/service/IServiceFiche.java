package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.Fiche;

public interface IServiceFiche {
	public List<Fiche> rechercheFiche();
	public Fiche rechercheFicheId(final int id);
	public void creerFiche(final Fiche pFiche);
	public void modifierFiche(final Fiche pFiche);
	public void supprimerFiche(final Fiche pFiche);
}
