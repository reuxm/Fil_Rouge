package groupe1.filrouge.controller.form;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;

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
}
