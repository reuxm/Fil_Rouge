package groupe1.filrouge.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groupe1.filrouge.entity.Client;
import groupe1.filrouge.entity.Devis;
import groupe1.filrouge.entity.User;
import groupe1.filrouge.entity.Vehicule;
import groupe1.filrouge.service.IServiceClient;
import groupe1.filrouge.service.IServiceDevis;
import groupe1.filrouge.service.IServiceUser;
import groupe1.filrouge.service.IServiceVehicule;

/**
 * Class Rest qui permet de faire le lien entre les Devis et l'application Angular
 * @author Groupe 1
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Rest/entity")
public class DevisRest {

	@Autowired
	private IServiceDevis sdevis;
	
	@Autowired
	private IServiceVehicule svehicule;

	@Autowired
	private IServiceUser suser;
	
	@Autowired
	private IServiceClient sclient;
	
	/**
	 * Permet de récupérer une liste de devis
	 * @return liste de devis
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/devis")
	public List<Devis> listdevis() {
		return sdevis.list();
	}
	/**
	 * Permet de créer un devis
	 * @param d devis
	 */
	@PostMapping("/createdevis")
	public void createD(@RequestBody Devis d) {
		sdevis.create(d);
	}
	/**
	 * Permet de trouver un devis suivant son id
	 * @param id
	 * @return le devis
	 */
	@GetMapping("/devis/{id}")
	public Devis find(@PathVariable("id") int id) {
		return sdevis.find(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/devis/vehicule/{id}")
	public Vehicule getVehicule( @PathVariable("id") int id ) {
		return svehicule.rechercheVehiculeId(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/devis/client/{id}")
	public Client getClient( @PathVariable("id") int id ) {
		return sclient.find(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/devis/user/{id}")
	public User getUser( @PathVariable("id") int id ) {
		return suser.rechercheUserId(id);
	}
	

}
