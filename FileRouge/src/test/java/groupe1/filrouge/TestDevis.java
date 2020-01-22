package groupe1.filrouge;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import groupe1.filrouge.entity.Devis;
import groupe1.filrouge.service.IServiceClient;
import groupe1.filrouge.service.IServiceDevis;
import groupe1.filrouge.service.IServiceUser;
import groupe1.filrouge.service.IServiceVehicule;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDevis {


	@Autowired
	private IServiceDevis serviceDevis;
	@Autowired
	private IServiceClient serviceClient;
	@Autowired
	private IServiceVehicule serviceVehicule;
	@Autowired
	private IServiceUser serviceUser;

	
	@Before
	public void init() {
		System.out.println("=====================================================");
	}
	@Test
	public void testRecherche() {
		System.out.println("---------TEST RECHERCHE---------");
		System.out.println(serviceDevis.list());
	}
		
	@Test
	public void testRechercheId() {
		System.out.println("---------TEST RECHERCHE ID---------");
		System.out.println(serviceDevis.find(1));
	}
	
	@Test
	public void testAjout() {
		System.out.println("---------TEST AJOUT---------");
		Devis pDevis = new Devis();
		pDevis.setDatecreation(new Date());
		pDevis.setEtat(true);	
		pDevis.setClient(serviceClient.find(1));
		pDevis.setVehicule(serviceVehicule.rechercheVehiculeId(1));
		pDevis.setUser(serviceUser.rechercheUserId(1));
		serviceDevis.create(pDevis);
		System.out.println(serviceDevis.list());
		
		serviceDevis.delete(pDevis);
		System.out.println(serviceDevis.list());
	}
	
	@Test
	public void testModif() {
		System.out.println("---------TEST MODIF---------");
		Devis pDevis = new Devis();
		pDevis.setDatecreation(new Date());
		pDevis.setEtat(true);	
		pDevis.setClient(serviceClient.find(1));
		pDevis.setVehicule(serviceVehicule.rechercheVehiculeId(1));
		pDevis.setUser(serviceUser.rechercheUserId(1));
		serviceDevis.create(pDevis);
		System.out.println(serviceDevis.list());	
		pDevis.setDatecreation(new Date());
		pDevis.setEtat(false);	
		pDevis.setClient(serviceClient.find(3));
		pDevis.setVehicule(serviceVehicule.rechercheVehiculeId(2));
		pDevis.setUser(serviceUser.rechercheUserId(2));
		serviceDevis.update(pDevis);
		System.out.println(serviceDevis.list());	
		serviceDevis.delete(pDevis);
		System.out.println(serviceDevis.list());
	}
	
	@Test
	public void testSuppr() {
		System.out.println("---------TEST SUPPR---------");
		Devis pDevis = new Devis();
		pDevis.setDatecreation(new Date());
		pDevis.setEtat(true);	
		pDevis.setClient(serviceClient.find(1));
		pDevis.setVehicule(serviceVehicule.rechercheVehiculeId(1));
		pDevis.setUser(serviceUser.rechercheUserId(1));
		serviceDevis.create(pDevis);
		System.out.println(serviceDevis.list());	
		serviceDevis.delete(pDevis);
		System.out.println(serviceDevis.list());
	}

}
