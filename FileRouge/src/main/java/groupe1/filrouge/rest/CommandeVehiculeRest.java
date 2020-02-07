package groupe1.filrouge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groupe1.filrouge.entity.CommandeVehicule;
import groupe1.filrouge.service.IServiceCommandeVehicule;

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

}
