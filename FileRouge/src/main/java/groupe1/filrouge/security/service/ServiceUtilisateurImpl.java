package groupe1.filrouge.security.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import groupe1.filrouge.entity.User;
import groupe1.filrouge.security.dao.DaoUserDetail;


@Service
public class ServiceUtilisateurImpl implements UserDetailsService {

    private final DaoUserDetail utilisateurRepository;

    @Autowired
    public ServiceUtilisateurImpl(DaoUserDetail utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Objects.requireNonNull(username);
        User utilisateur = utilisateurRepository.loadUserByUsername(username);

        return utilisateur;
    }

	
}