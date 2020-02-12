package groupe1.filrouge.rest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import groupe1.filrouge.entity.LogResult;
import groupe1.filrouge.entity.LoginInfo;
import groupe1.filrouge.entity.User;
import groupe1.filrouge.service.IServiceProfil;
import groupe1.filrouge.service.IServiceUser;

@RestController
@RequestMapping("/Rest/login")
@CrossOrigin(origins="http://127.0.0.1:4200")
public class LoginRest {

	@Autowired
	private IServiceUser service;
	
	@Autowired IServiceProfil profilService;
	
	@PostMapping("/test")
	public LogResult testLogin( @RequestBody LoginInfo infos ) {
		User user = service.get( infos.getLogin() );
		boolean b = user!=null && !user.getSuspended() && BCrypt.checkpw( infos.getPwd(), user.getPassword() );
		return b ? new LogResult(
				user.getProfils().contains( profilService.rechercheProfilId( 1 ) ),//Mecanicien
				user.getProfils().contains( profilService.rechercheProfilId( 3 ) ) //Commercial
		) : null;
	}
	
}
