package groupe1.filrouge.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import groupe1.filrouge.controller.form.UserForm;
import groupe1.filrouge.entity.Profil;
import groupe1.filrouge.entity.User;
import groupe1.filrouge.service.IServiceProfil;
import groupe1.filrouge.service.IServiceUser;

@Controller
public class UserController {
	
	@Autowired
	private IServiceUser service;
	
	@Autowired
	private IServiceProfil pService;
	
	@GetMapping("/users")
	public String readAllUsers( Model pmodel ) {
		List<User> lu = service.rechercheUser();
		pmodel.addAttribute( "users", lu );
		
		UserForm form = new UserForm();
		form.setId( 0 );
		pmodel.addAttribute( "form", form );
		pmodel.addAttribute( "profils", pService.rechercheProfil() );
		return "users";
	}
	
	@PostMapping("/users")
	public String createUser( Model pmodel, @Valid @ModelAttribute(name="form") UserForm form, BindingResult presult ) {
		if( !form.getPass1().equals( form.getPass2() ) ) {
			presult.addError( new ObjectError("", "Les 2 mots de passes sont différents"));
		}
		
		if( !presult.hasErrors() ) {
			User user = new User();
			user.setLastname( form.getPrenom() );
			user.setFirstname( form.getNom() );
			user.setLogin( form.getLogin() );
			user.setPassword( BCrypt.hashpw( form.getPass1(), BCrypt.gensalt(10) ) );
			boolean[] p = form.getProfils();
			List<Profil> profils = new ArrayList<Profil>();
			for( int i=0 ; i<5 ; i++) {
				if( p[i] ) {
					profils.add( pService.rechercheProfilId( i+1 ) );
				}
			}
			user.setProfils( profils );
			service.creerUser( user );
		}
		else {
			pmodel.addAttribute( "errors", presult.getAllErrors() );
			pmodel.addAttribute( "nom", form.getNom() );
			pmodel.addAttribute( "prenom", form.getPrenom() );
			pmodel.addAttribute( "login", form.getLogin() );
			pmodel.addAttribute( "ps", form.getProfils() );
		}
		
		return readAllUsers( pmodel );
	}
	
	@GetMapping("/users/{id}")
	public String updateUser( Model pmodel, @PathVariable Integer id ) {
		User user = service.rechercheUserId( id );
		UserForm form = new UserForm();
		form.setId( id );

		pmodel.addAttribute( "form", form );
		pmodel.addAttribute( "nom", user.getLastname() );
		pmodel.addAttribute( "prenom", user.getFirstname() );
		pmodel.addAttribute( "login", user.getLogin() );
		Collection<Profil> profils = user.getProfils();
		pmodel.addAttribute( "profil", new boolean[] {
				profils.contains( pService.rechercheProfilId( 1 ) ),
				profils.contains( pService.rechercheProfilId( 2 ) ),
				profils.contains( pService.rechercheProfilId( 3 ) ),
				profils.contains( pService.rechercheProfilId( 4 ) ),
				profils.contains( pService.rechercheProfilId( 5 ) )
		} );
		
		pmodel.addAttribute( "profils", pService.rechercheProfil() );
		
		return "formUser";
	}
	
	@PostMapping("/users/{id}")
	public String validUpdateUser( Model pmodel,  @PathVariable Integer id, @Valid @ModelAttribute(name="form") UserForm form, BindingResult presult ) {
		if( !form.getPass1().equals( form.getPass2() ) ) {
			presult.addError( new ObjectError("", "Les 2 mots de passes sont différents"));
		}
		
		if( !presult.hasErrors() ) {
			User user = new User();
			User original = service.rechercheUserId( id );
			user.setId( id );
			user.setLastname( form.getNom() );
			user.setFirstname( form.getPrenom() );
			user.setLogin( form.getLogin() );
			user.setPassword( original.getPassword());
			boolean[] p = form.getProfils();
			List<Profil> profils = new ArrayList<Profil>();
			for( int i=0 ; i<5 ; i++) {
				if( p[i] ) {
					profils.add( pService.rechercheProfilId( i+1 ) );
				}
			}
			user.setProfils( profils );
			service.modifierUser( user );
		}
		else {
			pmodel.addAttribute( "errors", presult.getAllErrors() );
			pmodel.addAttribute( "newnom", form.getNom() );
			pmodel.addAttribute( "newprenom", form.getPrenom() );
			pmodel.addAttribute( "newprofil", form.getProfils() );

			return updateUser( pmodel, id );
		}
		return readAllUsers( pmodel );
	}
	
	@GetMapping("/profils/{id}")
	public String listParProfil( Model pmodel, @PathVariable Integer id ) {
		List<String> errors = new ArrayList<String>();
		Profil profil = pService.rechercheProfilId( id );
		
		if( profil != null ) {
			pmodel.addAttribute( "users", profil.getUsers() );
			pmodel.addAttribute( "pid", profil.getId() );
			pmodel.addAttribute( "pname", profil.getName() );
		}
		else {
			errors.add( "profil inexistant" );
		}
		pmodel.addAttribute( "errors", errors );	
		
		return "profils";
	}
	
	@GetMapping("/profils/{id}/{userid}")
	public String removeProfil( Model pmodel, @PathVariable Integer id , @PathVariable Integer userid ) {
		List<String> errors = new ArrayList<String>();
		Profil profil = pService.rechercheProfilId( id );
		User user = service.rechercheUserId( userid );

		if( profil == null ) {
			errors.add( "profil inexistant" );
		}
		if( user == null ) {
			errors.add( "utilisateur inexistant" );
		}
		
		if( errors.size() == 0 ) {
			user.getProfils().remove( profil );
			service.modifierUser( user );
		}
		
		pmodel.addAttribute( "errors", errors );	
		return listParProfil( pmodel, id );
	}
	
	@GetMapping("/blockUser/{id}")
	public String blockUser( Model pmodel, @PathVariable Integer id ) {
		User user = service.rechercheUserId( id );
		user.toogleSupended();
		service.modifierUser( user );
		return readAllUsers( pmodel );
	}
	
}
