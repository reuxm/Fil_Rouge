package groupe1.filrouge;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import groupe1.filrouge.entity.Vehicule;
import groupe1.filrouge.service.IServiceVehicule;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestVehicule {
	@Autowired
	private IServiceVehicule serviceVehicule;
	
	@Before
	public void init() {
		System.out.println("=====================================================");
	}
	
	@Test
	public void testRecherche() {
		System.out.println("---------TEST RECHERCHE---------");
		System.out.println(serviceVehicule.rechercheVehicule());
	}
	
	@Test
	public void testRechercheId() {
		System.out.println("---------TEST RECHERCHE ID---------");
		System.out.println(serviceVehicule.rechercheVehiculeId(1));
	}
	
	@Test
	public void testAjout() {
		System.out.println("---------TEST AJOUT---------");
		Vehicule vehicule = new Vehicule();
		vehicule.setModele("test");
		vehicule.setQte(5);
		vehicule.setPrixHT(new Float(66666.66));
		vehicule.setDateCreation(new Date());
		
		serviceVehicule.creerVehicule(vehicule);
		System.out.println(serviceVehicule.rechercheVehicule());
		
		serviceVehicule.supprimerVehicule(vehicule);
		System.out.println(serviceVehicule.rechercheVehicule());
	}
	
	@Test
	public void testModif() {
		System.out.println("---------TEST MODIF---------");
		Vehicule vehicule = new Vehicule();
		vehicule.setModele("test");
		vehicule.setQte(5);
		vehicule.setPrixHT(new Float(66666.66));
		vehicule.setDateCreation(new Date());
		
		serviceVehicule.creerVehicule(vehicule);
		System.out.println(serviceVehicule.rechercheVehicule());
		
		vehicule.setModele("test modif");
		vehicule.setQte(10);
		vehicule.setPrixHT(new Float(99999.99));
		vehicule.setDateCreation(new Date());
		
		serviceVehicule.modifierVehicule(vehicule);
		System.out.println(serviceVehicule.rechercheVehicule());
		
		serviceVehicule.supprimerVehicule(vehicule);
		System.out.println(serviceVehicule.rechercheVehicule());
	}
	
	@Test
	public void testSuppr() {
		System.out.println("---------TEST SUPPR---------");
		Vehicule vehicule = new Vehicule();
		vehicule.setModele("test");
		vehicule.setQte(5);
		vehicule.setPrixHT(new Float(66666.66));
		vehicule.setDateCreation(new Date());
		
		serviceVehicule.creerVehicule(vehicule);
		System.out.println(serviceVehicule.rechercheVehicule());
		
		serviceVehicule.supprimerVehicule(vehicule);
		System.out.println(serviceVehicule.rechercheVehicule());
	}

}
