package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.Profil;

public interface IServiceProfil {
	public List<Profil> rechercheProfil();
	public Profil rechercheProfilId(final int id);
	public void creerProfil(final Profil pProfil);
	public void modifierProfil(final Profil pProfil);
	public void supprimerProfil(final Profil pProfil);
}
