package groupe1.filrouge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groupe1.filrouge.entity.CommandeVehicule;
import groupe1.filrouge.entity.Tache;
import groupe1.filrouge.service.IServiceCommandeVehicule;

/**
 * 
 * @author Groupe 1
 * Class commande véhicule rest qui permet de faire le lien avec l'appli Angular
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Rest/entity/commande")
public class CommandeVehiculeRest {

	@Autowired
	private IServiceCommandeVehicule service;
	
	/**
	 * Permet de renvoyer une liste de commandes de véhicules
	 * @return liste de commandes
	 */
	@GetMapping("/vehicules")
	public List<CommandeVehicule> listVehicule() {
		return service.list();
	}
	
	/**
	 * Permet de renvoyer une commande de véhicule suivant l'id de celle-ci
	 * @param id de la commande
	 * @return Commande de véhicule
	 */
	@GetMapping("/vehicule/{id}")
	public CommandeVehicule getVehicule( @PathVariable("id") int id ) {
		return service.find( id );
	}
	
	/**
	 * @param commande
	 * Permet de modifié depuis l'appli Angular les commandes
	 */
	@PostMapping(value="/vehicules/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateCommande(@RequestBody CommandeVehicule commande) {
		service.update(commande);
	}
}
