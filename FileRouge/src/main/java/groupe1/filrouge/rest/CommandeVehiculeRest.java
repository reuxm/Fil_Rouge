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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Rest/entity/commande")
public class CommandeVehiculeRest {

	@Autowired
	private IServiceCommandeVehicule service;
	
	@GetMapping("/vehicules")
	public List<CommandeVehicule> listVehicule() {
		return service.list();
	}
	
	@GetMapping("/vehicule/{id}")
	public CommandeVehicule getVehicule( @PathVariable("id") int id ) {
		return service.find( id );
	}
	
	@PostMapping(value="/vehicules/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateCommande(@RequestBody CommandeVehicule commande) {
		service.update(commande);
	}
}
