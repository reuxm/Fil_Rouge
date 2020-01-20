package groupe1.filrouge;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import groupe1.filrouge.entity.CommandePiece;
import groupe1.filrouge.service.IServiceCommandePiece;
import groupe1.filrouge.service.IServicePiece;
import groupe1.filrouge.service.IServiceUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCommandePiece {
	@Autowired
	IServiceCommandePiece serviceCommandePiece;
	@Autowired
	IServicePiece servicePiece;
	@Autowired
	IServiceUser serviceUser;
	
	@Before
	public void init() {
		System.out.println("=====================================================");
	}
	
	@Test
	public void testRecherche() {
		System.out.println("---------TEST RECHERCHE---------");
		System.out.println(serviceCommandePiece.list());
	}
	
	@Test
	public void testRechercheId() {
		System.out.println("---------TEST RECHERCHE ID---------");
		System.out.println(serviceCommandePiece.find(1));
	}
	
	@Test
	public void testAjout() {
		System.out.println("---------TEST AJOUT---------");
		CommandePiece cmd = new CommandePiece();
		cmd.setPiece(servicePiece.recherchePieceId(1));
		cmd.setUser(serviceUser.rechercheUserId(1));
		cmd.setQte(5);
		cmd.setDateCreation(new Date());
		
		serviceCommandePiece.create(cmd);
		System.out.println(serviceCommandePiece.list());
		
		serviceCommandePiece.delete(cmd);
		System.out.println(serviceCommandePiece.list());
	}
	
	@Test
	public void testModif() {
		System.out.println("---------TEST MODIF---------");
		CommandePiece cmd = new CommandePiece();
		cmd.setPiece(servicePiece.recherchePieceId(1));
		cmd.setUser(serviceUser.rechercheUserId(1));
		cmd.setQte(5);
		cmd.setDateCreation(new Date());
		
		serviceCommandePiece.create(cmd);
		System.out.println(serviceCommandePiece.list());
		
		cmd.setPiece(servicePiece.recherchePieceId(2));
		cmd.setUser(serviceUser.rechercheUserId(2));
		cmd.setQte(3);
		cmd.setDateCreation(new Date());
		
		serviceCommandePiece.update(cmd);
		System.out.println(serviceCommandePiece.list());
		
		serviceCommandePiece.delete(cmd);
		System.out.println(serviceCommandePiece.list());
	}
	
	@Test
	public void testSuppr() {
		System.out.println("---------TEST SUPPR---------");
		CommandePiece cmd = new CommandePiece();
		cmd.setPiece(servicePiece.recherchePieceId(1));
		cmd.setUser(serviceUser.rechercheUserId(1));
		cmd.setQte(5);
		cmd.setDateCreation(new Date());
		
		serviceCommandePiece.create(cmd);
		System.out.println(serviceCommandePiece.list());
		
		serviceCommandePiece.delete(cmd);
		System.out.println(serviceCommandePiece.list());
	}
	
}
