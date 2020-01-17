package groupe1.filrouge;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import groupe1.filrouge.entity.Piece;
import groupe1.filrouge.service.IServicePiece;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestPiece {
	@Autowired
	private IServicePiece servicePiece;
	
	@Before
	public void init() {
		System.out.println("=====================================================");
	}
	
	@Test
	public void testRecherche() {
		System.out.println("---------TEST RECHERCHE---------");
		System.out.println(servicePiece.recherchePiece());
	}
	
	@Test
	public void testRechercheId() {
		System.out.println("---------TEST RECHERCHE ID---------");
		System.out.println(servicePiece.recherchePieceId(1));
	}
	
	@Test
	public void testAjout() {
		System.out.println("---------TEST AJOUT---------");
		Piece piece = new Piece();
		piece.setLibelle("test");
		piece.setQte(5);
		piece.setDateCreation(new Date());
		
		servicePiece.creerPiece(piece);
		System.out.println(servicePiece.recherchePiece());
		
		servicePiece.supprimerPiece(piece);
		System.out.println(servicePiece.recherchePiece());
	}
	
	@Test
	public void testModif() {
		System.out.println("---------TEST MODIF---------");
		Piece piece = new Piece();
		piece.setLibelle("test");
		piece.setQte(5);
		piece.setDateCreation(new Date());
		
		servicePiece.creerPiece(piece);
		System.out.println(servicePiece.recherchePiece());
		
		piece.setLibelle("test modif");
		piece.setQte(10);
		piece.setDateCreation(new Date());
		
		servicePiece.modifierPiece(piece);
		System.out.println(servicePiece.recherchePiece());
		
		servicePiece.supprimerPiece(piece);
		System.out.println(servicePiece.recherchePiece());
	}
	
	@Test
	public void testSuppr() {
		System.out.println("---------TEST SUPPR---------");
		Piece piece = new Piece();
		piece.setLibelle("test");
		piece.setQte(5);
		piece.setDateCreation(new Date());
		
		servicePiece.creerPiece(piece);
		System.out.println(servicePiece.recherchePiece());
		
		servicePiece.supprimerPiece(piece);
		System.out.println(servicePiece.recherchePiece());
	}

}
