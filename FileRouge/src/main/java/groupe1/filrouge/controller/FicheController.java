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
import groupe1.filrouge.controller.form.FicheFormUpdate;
import groupe1.filrouge.entity.Fiche;
import groupe1.filrouge.service.IServiceClient;
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
	
	@GetMapping("/fiches")
	public String readAllFiches( Model pmodel ) {
		List<Fiche> lf = service.rechercheFiche();
		pmodel.addAttribute( "listefiches", lf );
		return "fiches";
	}
	
	@GetMapping("/creerFiche")
	public String createFiche( Model pmodel ) {
		FicheForm form = new FicheForm();
		form.setId(0);
		pmodel.addAttribute( "form", form );
		pmodel.addAttribute( "listPriorites", pService.recherchePriorite() );
		pmodel.addAttribute( "listClients", cService.list() );
		return "formFiche";
	}

	@PostMapping("/validCreerFiche")
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
		}
		return readAllFiches( pmodel );
	}
	
	@GetMapping("/modifierFiche/{id}")
	public String updateFiche( Model pmodel, @PathVariable Integer id ) {
		Fiche f = service.rechercheFicheId( id );
		FicheFormUpdate form = new FicheFormUpdate();
		form.setId( id );
		pmodel.addAttribute( "form", form );
		pmodel.addAttribute( "priorite", f.getPriorite().getLibelle() );
		pmodel.addAttribute( "description", f.getDescription() );
		pmodel.addAttribute( "listPriorites", pService.recherchePriorite() );
		return "formFicheUpdate";
	}

	@PostMapping("/validModifFiche")
	public String validUpdate( Model pmodel, @Valid @ModelAttribute(name="form") FicheFormUpdate form, BindingResult presult ) {
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
			
			boolean end = Boolean.parseBoolean( form.getCloturer() );
			if( end ) {
				fiche.setEtat( end );
				fiche.setDateCloture( new Date() );
			}
		}
		return readAllFiches( pmodel );
	}
	
}
