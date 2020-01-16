package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.Vehicule;

public interface IServiceVehicule {

	public List<Vehicule> rechercheVehicule();
	public Vehicule rechercheVehiculeId(final int id);
	public void creerVehicule(final Vehicule vehicule);
	public void modifierVehicule(final Vehicule vehicule);
	public void supprimerVehicule(final Vehicule pvehicule);
	}