package groupe1.filrouge.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import groupe1.filrouge.security.dao.DaoUserDetail;

public class AppAuthProvider extends DaoAuthenticationProvider {

    @Autowired
    DaoUserDetail utilisateurDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) 
    		throws AuthenticationException {
    	

        UsernamePasswordAuthenticationToken auth = 
        		(UsernamePasswordAuthenticationToken) authentication;

        String name = auth.getName();
        String password = auth.getCredentials()
                .toString();

        System.err.println(name);
        
        UserDetails utilisateur = 
        		utilisateurDetailsService.loadUserByUsername(name);

        if (utilisateur == null) {
            throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        }
        System.err.println(utilisateur.getAuthorities());
        return new UsernamePasswordAuthenticationToken(
        		utilisateur, null, utilisateur.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;

    }
}
