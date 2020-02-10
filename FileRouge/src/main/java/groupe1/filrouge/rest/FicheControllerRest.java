package groupe1.filrouge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groupe1.filrouge.entity.Fiche;
import groupe1.filrouge.service.IServiceFiche;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/Rest/entity")
public class FicheControllerRest {
	
	@Autowired
	private IServiceFiche serviceFiche;
	
	@GetMapping("/fiches")
	public List<Fiche> readAllFiches() {
		return serviceFiche.rechercheFiche();
	}
	
	@GetMapping("/fiches/{id}")
	public Fiche readFiche(@PathVariable("id") int id) {
		return serviceFiche.rechercheFicheId(id);
	}

}
