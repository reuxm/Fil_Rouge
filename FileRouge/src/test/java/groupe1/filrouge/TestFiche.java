package groupe1.filrouge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import groupe1.filrouge.entity.Fiche;
import groupe1.filrouge.service.IServiceClient;
import groupe1.filrouge.service.IServiceFiche;
import groupe1.filrouge.service.IServicePriorite;
import groupe1.filrouge.service.IServiceUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestFiche {

	@Autowired
	private IServiceFiche service;

	@Autowired
	private IServiceClient cService;
	
	@Autowired
	private IServicePriorite pService;
	
	@Autowired
	private IServiceUser uService;

	private Fiche generateFiche() {
		Fiche fiche = new Fiche();
		fiche.setClient( cService.find( 1 ) );
		fiche.setDateCreation( new Date() );
		fiche.setDescription( "test" );
		fiche.setEtat( false );
		fiche.setPriorite( pService.recherchePrioriteId( 1 ) );
		fiche.setPrix( 1.0f );
		fiche.setTva( 0.2f );
		fiche.setUser( uService.rechercheUserId( 1 ) );
		return fiche;
	}
	
	@Before
	public void init() {
		System.out.println("=====================================================");
	}
	
	@Test
	public void testCreate() {
		System.out.println("---------TEST CREATION---------");
		
		assertEquals( service.rechercheFiche().size(), 2 );
		
		Fiche fiche = generateFiche();
		
		service.creerFiche( fiche );
		
		assertEquals( service.rechercheFiche().size(), 3 );
		
		service.rechercheFiche().stream().forEach(
			f -> {
				if( f.getDescription().equals("test") ) 
					service.supprimerFiche( fiche );	
				}
		);
		
		assertEquals( service.rechercheFiche().size(), 2 );
	}
	
	@Test
	public void testRead() {
		System.out.println("---------TEST LECTURE---------");

		List<Fiche> fiches = service.rechercheFiche();
		assertEquals( fiches.size(), 2 );
		fiches.stream().forEach(
			f -> System.out.println( f )
		);
	}
	
	@Test
	public void testModif() {
		System.out.println("---------TEST MODIF---------");
		
		Fiche fiche = generateFiche();

		service.creerFiche( fiche );
		
		fiche.setDateCloture( new Date() );
		
		service.modifierFiche( fiche );
		
		service.rechercheFiche().stream().forEach(
			f -> assertTrue( !f.getDescription().equals("test") || f.getDateCloture() != null )
		);
		
		service.rechercheFiche().stream().forEach(
			f -> {
				if( f.getDescription().equals("test") ) 
					service.supprimerFiche( fiche );	
				}
		);
		
	}
	
}
