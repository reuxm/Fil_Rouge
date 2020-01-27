package groupe1.filrouge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import groupe1.filrouge.entity.User;
import groupe1.filrouge.service.IServiceProfil;
import groupe1.filrouge.service.IServiceUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUser {
	
	@Autowired
	private IServiceUser service;
	
	@Autowired IServiceProfil pService;
	
	private User generateUser() {
		User user = new User();
		user.setFirstname( "test" );
		user.setLastname( "test" );
		user.setLogin( "test" );
		user.setPassword( "test") ;
		user.setProfils( Arrays.asList(
			pService.rechercheProfilId( 1 )
		) );
		return user;
	}
	
	@Before
	public void init() {
		System.out.println("=====================================================");
	}
	
	@Test
	public void testCreate() {
		System.out.println("---------TEST CREATION---------");
		
		assertEquals( service.rechercheUser().size(), 2 );
		
		User user = generateUser();
		
		service.creerUser( user );
		
		assertEquals( service.rechercheUser().size(), 3 );
		
		service.rechercheUser().stream().forEach(
			u -> {
				if( u.getLogin().equals("test") ) 
					service.supprimerUser( u );	
				}
		);
		
		assertEquals( service.rechercheUser().size(), 2 );
	}
	
	@Test
	public void testRead() {
		System.out.println("---------TEST LECTURE---------");

		List<User> users = service.rechercheUser();
		assertEquals( users.size(), 2 );
		users.stream().forEach(
			u -> System.out.println( u )
		);
	}
	
	@Test
	public void testModif() {
		System.out.println("---------TEST MODIF---------");
		
		User user = generateUser();
		
		service.creerUser( user );
		
		user.setPassword( "azertyuiop" );
		
		service.modifierUser( user );
		
		service.rechercheUser().stream().forEach(
			u -> assertTrue( !u.getLogin().equals( "test" ) || u.getPassword().equals( "azertyuiop"  ) )
		);
		
		service.rechercheUser().stream().forEach(
			u -> {
				if( u.getLogin().equals( "test" ) ) 
					service.supprimerUser( u );	
			}
		);
	}
}
