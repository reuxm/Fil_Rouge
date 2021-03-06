package groupe1.filrouge.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groupe1.filrouge.entity.Vehicule;
import groupe1.filrouge.service.IServiceVehicule;

/**
 * Class Rest qui permet de faire le lien entre l'entity java Vehicule et l'application Angular
 * @author Groupe 1 
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Rest/entity")
public class VehiculeRest {

	@Autowired
	private IServiceVehicule service;
	
	@GetMapping("/vehicules")
	public List<Vehicule> listVehicule() {
		return service.rechercheVehicule();
	}
	
	@GetMapping("/vehicule/{id}")
	public Vehicule getVehicule( @PathVariable("id") int id ) {
		return service.rechercheVehiculeId( id );
	}
}
