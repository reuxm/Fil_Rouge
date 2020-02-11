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

import groupe1.filrouge.entity.Tache;
import groupe1.filrouge.service.IServiceTache;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Rest/entity")
public class TacheRest {
	
	@Autowired
	private IServiceTache serviceTache;
	
	@GetMapping("/taches")
	public List<Tache> readAllTaches() {
		return serviceTache.rechercheTache();
	}	
	
	@GetMapping("/taches/{id}")
	public Tache readTache(@PathVariable("id") int id) {
		return serviceTache.rechercheTacheId(id);
	}
	
	@PostMapping(value="/updateTache", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateTache(@RequestBody Tache tache) {
		serviceTache.modifierTache(tache);
	}
}
