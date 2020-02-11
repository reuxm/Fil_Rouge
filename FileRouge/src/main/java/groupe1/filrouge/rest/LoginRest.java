package groupe1.filrouge.rest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groupe1.filrouge.entity.LoginInfo;
import groupe1.filrouge.entity.User;
import groupe1.filrouge.service.IServiceUser;

@RestController
@RequestMapping("/Rest/login")
public class LoginRest {

	@Autowired
	private IServiceUser service;
	
	@PostMapping("/test")
	public boolean testLogin( @RequestBody LoginInfo infos ) {
		User user = service.get( infos.getLogin() );
		return BCrypt.checkpw( infos.getPwd(), user.getPassword() );
	}
	
}
