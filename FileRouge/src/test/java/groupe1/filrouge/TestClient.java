package groupe1.filrouge;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import groupe1.filrouge.entity.Client;
import groupe1.filrouge.service.IServiceClient;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TestClient {
	@Autowired
	private IServiceClient serviceClient;
	
	@Before
	public void init() {
		System.out.println("=====================================================");
	}
	@Test
	public void testRecherche() {
		System.out.println("---------TEST RECHERCHE---------");
		System.out.println(serviceClient.list());
	}
		
	@Test
	public void testRechercheId() {
		System.out.println("---------TEST RECHERCHE ID---------");
		System.out.println(serviceClient.find(1));
	}
	
	@Test
	public void testAjout() {
		System.out.println("---------TEST AJOUT---------");
		Client pclient = new Client();
		pclient.setFirstname("Marie");
		pclient.setName("Baumont");	
		pclient.setAdresse("15b rue general André");
		pclient.setCodePostal("38000");
		pclient.setMobile("0607843052");
		pclient.setTelephone(" ");
		pclient.setVille("Lyon");
		pclient.setCloturer(false);
		serviceClient.create(pclient);
		System.out.println(serviceClient.list());
		
		serviceClient.delete(pclient);
		System.out.println(serviceClient.list());
	}
	
	@Test
	public void testModif() {
		System.out.println("---------TEST MODIF---------");
		Client pclient = new Client();
		pclient.setFirstname("Marie");
		pclient.setName("Baumont");	
		pclient.setAdresse("15b rue general André");
		pclient.setCodePostal("38000");
		pclient.setMobile("0607843052");
		pclient.setTelephone(" ");
		pclient.setVille("Lyon");
		pclient.setCloturer(false);
		serviceClient.create(pclient);
		System.out.println(serviceClient.list());	
		pclient.setFirstname("Manon");
		pclient.setName("Liversain");	
		pclient.setAdresse("15 rue general André");
		pclient.setCodePostal("69008");
		pclient.setMobile("0607003052");
		pclient.setTelephone("123");
		pclient.setVille("Lyon 8");
		pclient.setCloturer(true);

		serviceClient.update(pclient);
		System.out.println(serviceClient.list());
		
		serviceClient.delete(pclient);
		System.out.println(serviceClient.list());
	}
	
	@Test
	public void testSuppr() {
		System.out.println("---------TEST SUPPR---------");
		Client pclient = new Client();
		pclient.setFirstname("Marie");
		pclient.setName("Baumont");	
		pclient.setAdresse("15b rue general André");
		pclient.setCodePostal("38000");
		pclient.setMobile("0607843052");
		pclient.setTelephone(" ");
		pclient.setVille("Lyon");
		pclient.setCloturer(false);
		serviceClient.create(pclient);
		
		serviceClient.create(pclient);
		System.out.println(serviceClient.list());
		
		serviceClient.delete(pclient);
		System.out.println(serviceClient.list());
	}

}

