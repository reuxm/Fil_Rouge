package groupe1.filrouge;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import groupe1.filrouge.entity.Tache;
import groupe1.filrouge.service.IServiceFiche;
import groupe1.filrouge.service.IServicePiece;
import groupe1.filrouge.service.IServicePriorite;
import groupe1.filrouge.service.IServiceTache;
import groupe1.filrouge.service.IServiceUser;
import groupe1.filrouge.service.IServiceTache;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTache {
	@Autowired
	private IServiceTache serviceTache;
	@Autowired
	private IServiceFiche serviceFiche;
	@Autowired
	private IServicePiece servicePiece;
	@Autowired
	private IServiceUser serviceUser;
	@Autowired
	private IServicePriorite servicePriorite;
	
	@Before
	public void init() {
		System.out.println("=====================================================");
	}
	@Test
	public void testRecherche() {
		System.out.println("---------TEST RECHERCHE---------");
		System.out.println(serviceTache.rechercheTache());
	}
		
	@Test
	public void testRechercheId() {
		System.out.println("---------TEST RECHERCHE ID---------");
		System.out.println(serviceTache.rechercheTacheId(1));
	}
	
	@Test
	public void testAjout() {
		System.out.println("---------TEST AJOUT---------");
		Tache pTache = new Tache();
		pTache.setCommentaire("Premier Commentaire");
		pTache.setEtat(true);	
		pTache.setFiche(serviceFiche.rechercheFicheId(1));
		pTache.setPiece(servicePiece.recherchePieceId(1));
		pTache.setPriorite(servicePriorite.recherchePrioriteId(1));
		pTache.setUser(serviceUser.rechercheUserId(1));
		pTache.setQte(10);
		pTache.setLibelle("tache1");
		serviceTache.creerTache(pTache);
		System.out.println(serviceTache.rechercheTache());
		
		serviceTache.supprimerTache(pTache);
		System.out.println(serviceTache.rechercheTache());
	}
	
	@Test
	public void testModif() {
		System.out.println("---------TEST MODIF---------");
		Tache pTache = new Tache();
		pTache.setCommentaire("Premier Commentaire");
		pTache.setEtat(true);	
		pTache.setFiche(serviceFiche.rechercheFicheId(1));
		pTache.setPiece(servicePiece.recherchePieceId(1));
		pTache.setPriorite(servicePriorite.recherchePrioriteId(1));
		pTache.setUser(serviceUser.rechercheUserId(1));
		pTache.setQte(10);
		pTache.setLibelle("tache1");
		serviceTache.creerTache(pTache);
		System.out.println(serviceTache.rechercheTache());	
		pTache.setCommentaire("Deuxième Commentaire");
		pTache.setEtat(false);	
		pTache.setFiche(serviceFiche.rechercheFicheId(2));
		pTache.setPiece(servicePiece.recherchePieceId(2));
		pTache.setPriorite(servicePriorite.recherchePrioriteId(2));
		pTache.setUser(serviceUser.rechercheUserId(2));
		pTache.setQte(20);
		pTache.setLibelle("tache2");
		System.out.println(serviceTache.rechercheTache());
		serviceTache.modifierTache(pTache);
		System.out.println(serviceTache.rechercheTache());
		
		serviceTache.supprimerTache(pTache);
		System.out.println(serviceTache.rechercheTache());
	}
	
	@Test
	public void testSuppr() {
		System.out.println("---------TEST SUPPR---------");
		Tache pTache = new Tache();
		pTache.setCommentaire("Premier Commentaire");
		pTache.setEtat(true);	
		pTache.setFiche(serviceFiche.rechercheFicheId(1));
		pTache.setPiece(servicePiece.recherchePieceId(1));
		pTache.setPriorite(servicePriorite.recherchePrioriteId(1));
		pTache.setUser(serviceUser.rechercheUserId(1));
		pTache.setQte(10);
		pTache.setLibelle("tache1");
		serviceTache.creerTache(pTache);
		System.out.println(serviceTache.rechercheTache());
		serviceTache.supprimerTache(pTache);
		System.out.println(serviceTache.rechercheTache());
	}

}

