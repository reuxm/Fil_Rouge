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

import groupe1.filrouge.entity.Devis;
import groupe1.filrouge.service.IServiceDevis;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Rest/entity")
public class DevisRest {

	@Autowired
	private IServiceDevis sdevis;

	@GetMapping("/devis")
	public List<Devis> listdevis() {
		return sdevis.list();
	}

	@PostMapping("/createdevis")
	public void createD(@RequestBody Devis d) {
		sdevis.create(d);
	}

	@GetMapping("/devis/{id}")
	public Devis find(@PathVariable("id") int id) {
		return sdevis.find(id);
	}
  
}
