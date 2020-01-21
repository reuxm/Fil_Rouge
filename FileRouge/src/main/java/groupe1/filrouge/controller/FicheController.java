package groupe1.filrouge.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import groupe1.filrouge.controller.form.FicheForm;
import groupe1.filrouge.entity.FactureFiche;
import groupe1.filrouge.entity.Fiche;
import groupe1.filrouge.service.IServiceClient;
import groupe1.filrouge.service.IServiceFactureFiche;
import groupe1.filrouge.service.IServiceFiche;
import groupe1.filrouge.service.IServicePriorite;
import groupe1.filrouge.service.IServiceUser;

@Controller
public class FicheController {

	@Autowired
	private IServiceFiche service;
	
	@Autowired
	private IServicePriorite pService;
	
	@Autowired
	private IServiceClient cService;
	
	@Autowired
	private IServiceUser uService;
	
	@Autowired
	private IServiceFactureFiche fService;
	
	@GetMapping("/fiches")
	public String readAllFiches( Model pmodel ) {
		List<Fiche> lf = service.rechercheFiche();
		pmodel.addAttribute( "listefiches", lf );
		
		FicheForm form = new FicheForm();
		form.setId(0);
		pmodel.addAttribute( "form", form );
		pmodel.addAttribute( "listPriorites", pService.recherchePriorite() );
		pmodel.addAttribute( "listClients", cService.list() );
		
		return "fiches";
	}

	@PostMapping("/fiches")
	public String validCreate( Model pmodel, @Valid @ModelAttribute(name="form") FicheForm form, BindingResult presult ) {
		if( !presult.hasErrors() ) {
			Fiche fiche = new Fiche();
			fiche.setDateCreation(  new Date() );
			fiche.setEtat( false );
			fiche.setUser( uService.rechercheUser().iterator().next() );//TODO get logged user
			fiche.setPriorite( pService.recherchePrioriteId(
				Integer.parseInt( form.getPriorite() ) 
			) );
			fiche.setClient( cService.find( 
				Integer.parseInt( form.getClient() ) 
			) );
			fiche.setDescription( form.getDescription() );
			fiche.setPrix( form.getPrix() );
			fiche.setTva( form.getTva() );
			
			service.creerFiche( fiche );
		}
		else {
			pmodel.addAttribute( "errors", presult.getAllErrors() );
			pmodel.addAttribute( "description", form.getDescription() );
			pmodel.addAttribute( "prio", form.getPriorite() );
			pmodel.addAttribute( "client", form.getClient() );
			pmodel.addAttribute( "prix", form.getPrix() );
			pmodel.addAttribute( "tva", form.getTva() );
		}
		return readAllFiches( pmodel );
	}
	
	@GetMapping("/fiches/{id}")
	public String updateFiche( Model pmodel, @PathVariable Integer id ) {
		Fiche f = service.rechercheFicheId( id );
		FicheForm form = new FicheForm();
		form.setId( id );
		pmodel.addAttribute( "client", f.getClient().getId() );
		pmodel.addAttribute( "form", form );
		pmodel.addAttribute( "priorite", f.getPriorite().getId() );
		pmodel.addAttribute( "description", f.getDescription() );
		pmodel.addAttribute( "prix", f.getPrix() );
		pmodel.addAttribute( "tva", f.getTva() );
		pmodel.addAttribute( "listPriorites", pService.recherchePriorite() );
		return "formFicheUpdate";
	}

	@PostMapping("/fiches/{id}")
	public String validUpdate( Model pmodel,  @PathVariable Integer id, @Valid @ModelAttribute(name="form") FicheForm form, BindingResult presult ) {
		if( !presult.hasErrors() ) {
			Fiche fiche = new Fiche();
			Fiche original = service.rechercheFicheId( form.getId() );
			fiche.setId( original.getId() );
			fiche.setDateCreation(  original.getDateCreation() );
			fiche.setUser( original.getUser() );
			fiche.setClient( original.getClient() );
			
			fiche.setPriorite( pService.recherchePrioriteId(
				Integer.parseInt( form.getPriorite() ) 
			) );
			fiche.setDescription( form.getDescription() );
			fiche.setPrix( form.getPrix() );
			fiche.setTva( form.getTva() );
			
			if( form.getCloturer()!=null && form.getCloturer().equals("on") ) {
				clore(fiche);
			}
			
			service.modifierFiche( fiche );
		}
		else {
			pmodel.addAttribute( "errors", presult.getAllErrors() );
			pmodel.addAttribute( "newdescription", form.getDescription() );
			pmodel.addAttribute( "newprio", form.getPriorite() );
			pmodel.addAttribute( "newprix", form.getPrix() );
			pmodel.addAttribute( "newtva", form.getTva() );
			
			return updateFiche( pmodel, id );
		}
		return readAllFiches( pmodel );
	}
	
	@GetMapping("/clotureFiche/{id}")
	public String clotureFiche(Model pmodel, @PathVariable Integer id) {
		Fiche fiche = service.rechercheFicheId( id );
		clore(fiche);
		service.modifierFiche( fiche );
		return readAllFiches( pmodel );
	}

	private void clore(Fiche fiche) {
		fiche.setEtat( true );
		Date date = new Date();
		fiche.setDateCloture( date );
		
		FactureFiche facture = new FactureFiche();
		facture.setDateCreation( date );
		facture.setFiche( fiche );
		facture.setPrixHT( fiche.getPrix() );
		facture.setTVA( fiche.getTva() );
		
		fService.create( facture );
	}
	
}
