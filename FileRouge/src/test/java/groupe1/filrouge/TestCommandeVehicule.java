package groupe1.filrouge;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import groupe1.filrouge.entity.CommandeVehicule;
import groupe1.filrouge.service.IServiceCommandeVehicule;
import groupe1.filrouge.service.IServiceDevis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCommandeVehicule {

	@Autowired
	IServiceCommandeVehicule serviceCommandeVehicule;
	@Autowired
	IServiceDevis serviceDevis;

	@Before
	public void init() {
		System.out.println("=====================================================");
	}

	@Test
	public void testRecherche() {
		System.out.println("---------TEST RECHERCHE---------");
		System.out.println(serviceCommandeVehicule.list());
	}

	@Test
	public void testRechercheId() {
		System.out.println("---------TEST RECHERCHE ID---------");
		System.out.println(serviceCommandeVehicule.find(2));
	}

	@Test
	public void testAddCmd() {
		System.out.println("---------TEST AJOUT---------");
		CommandeVehicule cmd = new CommandeVehicule();
		cmd.setDateCloture(new Date());
		cmd.setDateCreation(new Date());
		cmd.setEtat(true);
		cmd.setLivre(false);
		cmd.setDevis(serviceDevis.find(1));
		
		serviceCommandeVehicule.create(cmd);
		System.out.println(serviceCommandeVehicule.list());
		
		serviceCommandeVehicule.delete(cmd);
		System.out.println(serviceCommandeVehicule.list());
		
	}

}
