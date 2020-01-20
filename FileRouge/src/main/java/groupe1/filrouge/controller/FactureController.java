package groupe1.filrouge.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import groupe1.filrouge.entity.FactureDevis;
import groupe1.filrouge.entity.FactureFiche;
import groupe1.filrouge.entity.Fiche;
import groupe1.filrouge.service.IServiceFactureDevis;
import groupe1.filrouge.service.IServiceFactureFiche;
import groupe1.filrouge.service.IServiceFiche;

@RestController
@RequestMapping("/Rest/entity")
public class FactureController {
	
	@Autowired
	private IServiceFactureFiche serviceF;
	
	@Autowired
	private IServiceFactureDevis serviceD;
	
	@Autowired
	private IServiceFiche serviceFiche;
	
	
	// Facture fiche
	
	@GetMapping("/facturesFiche")
	public List<FactureFiche> readAllF() {
		return serviceF.list();
	}
	
	@GetMapping("/factureFiche/{id}")
	public FactureFiche readF( @PathVariable("id") int id ) {
		return serviceF.find( id );
	}
	
	@PostMapping("/factureFiche")
	public void createF( @RequestBody FactureFiche f ) {
		serviceF.create( f );
	}
	
	@GetMapping("/fiche/{id}/facture")
	public void factureFromFiche( @PathVariable("id") int ficheId ) {
		Fiche fiche = serviceFiche.rechercheFicheId( ficheId );
		FactureFiche facture = new FactureFiche();
		
		facture.setDateCreation( new Date() );
		facture.setFiche( fiche );
		
		serviceF.create( facture );
	}
	
	// Facture devis
	
	@GetMapping("/facturesDevis")
	public List<FactureDevis> readAllD() {
		return serviceD.list();
	}
	
	@GetMapping("/facturesDevis/{id}")
	public FactureDevis readD( @PathVariable("id") int id ) {
		return serviceD.find( id );
	}
	
	@PostMapping("/facturesDevis")
	public void createD( @RequestBody FactureDevis f ) {
		serviceD.create( f );
	}
	
}
