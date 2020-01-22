package groupe1.filrouge.controller;

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


import groupe1.filrouge.controller.form.TacheForm;

import groupe1.filrouge.entity.Fiche;
import groupe1.filrouge.entity.Piece;
import groupe1.filrouge.entity.Priorite;
import groupe1.filrouge.entity.Tache;
import groupe1.filrouge.entity.User;
import groupe1.filrouge.service.IServiceFiche;
import groupe1.filrouge.service.IServicePiece;
import groupe1.filrouge.service.IServicePriorite;
import groupe1.filrouge.service.IServiceTache;
import groupe1.filrouge.service.IServiceUser;

@Controller
public class TacheController {
	@Autowired
	private IServiceTache service;
	@Autowired
	private IServiceFiche serviceFiche;
	@Autowired
	private IServicePriorite servicePriorite;
	@Autowired
	private IServicePiece servicePiece;
	@Autowired
	private IServiceUser serviceUser;
	
	private Tache convertForm(TacheForm tacheform) {
		Tache ptache= new Tache();
		ptache.setId(tacheform.getId());
		
		if(tacheform.getFiche() != null)
		{
			ptache.setQte(tacheform.getQte());
			ptache.setFiche(serviceFiche.rechercheFicheId(tacheform.getFiche()));
			ptache.setPriorite(servicePriorite.recherchePrioriteId(tacheform.getPriorite()));
			ptache.setPiece(servicePiece.recherchePieceId(tacheform.getPiece()));
			ptache.setUser(serviceUser.rechercheUserId(tacheform.getUser()));
		}
		else
		{
			ptache = service.rechercheTacheId(tacheform.getId());
			
		}
		ptache.setCommentaire(tacheform.getCommentaire());
		
		ptache.setEtat(tacheform.getEtat());
		System.out.println(ptache);
		return ptache;
	}
	
	@GetMapping("/afficherCreerTache")
	public String getAffiche(Model pModel) {
		List<Tache> ltache = service.rechercheTache();
		List<Piece> lpiece = servicePiece.recherchePiece();
		List<Fiche> lfiche = serviceFiche.rechercheFiche();
		List<Priorite> lpriorite = servicePriorite.recherchePriorite();
		List<User> luser = serviceUser.rechercheUser();
		pModel.addAttribute("listeuser", luser);	
		pModel.addAttribute("listepriorite", lpriorite);	
		pModel.addAttribute("listefiche", lfiche);	
		pModel.addAttribute("listepiece", lpiece);	
		pModel.addAttribute("listetache", ltache);	
		pModel.addAttribute("action", "CreerTache");
		if(!pModel.containsAttribute("errors")){
			TacheForm tacheform = new TacheForm();
			tacheform.setId(0);
			pModel.addAttribute("tacheform", tacheform);
		}
		return "taches";
	}
	
	@GetMapping("/afficherTache")
	public String getAfficheTache(Model pModel) {
		List<Tache> ltache = service.rechercheTache();
		List<Piece> lpiece = servicePiece.recherchePiece();
		List<Fiche> lfiche = serviceFiche.rechercheFiche();
		List<Priorite> lpriorite = servicePriorite.recherchePriorite();
		List<User> luser = serviceUser.rechercheUser();
		pModel.addAttribute("listeuser", luser);	
		pModel.addAttribute("listepriorite", lpriorite);	
		pModel.addAttribute("listefiche", lfiche);	
		pModel.addAttribute("listepiece", lpiece);	
		pModel.addAttribute("listetache", ltache);	
		pModel.addAttribute("action", "");
		TacheForm tacheform = new TacheForm();
		tacheform.setId(0);
		pModel.addAttribute("tacheform", tacheform);
		return "taches";
	}
	
	@GetMapping("/afficherModifierTache/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Tache tache = service.rechercheTacheId(id);
		pmodel.addAttribute("listetache", null);
		pmodel.addAttribute("action", "ModifierTache");
		List<Tache> ltache = service.rechercheTache();
		List<Piece> lpiece = servicePiece.recherchePiece();
		List<Fiche> lfiche = serviceFiche.rechercheFiche();
		List<Priorite> lpriorite = servicePriorite.recherchePriorite();
		List<User> luser = serviceUser.rechercheUser();
		pmodel.addAttribute("listeuser", luser);	
		pmodel.addAttribute("listepriorite", lpriorite);	
		pmodel.addAttribute("listefiche", lfiche);	
		pmodel.addAttribute("listepiece", lpiece);	
		pmodel.addAttribute("listetache", ltache);	
		if(pmodel.containsAttribute("tacheform") == false) {
			TacheForm tacheform = new TacheForm();
			tacheform.setId(tache.getId());
			tacheform.setCommentaire(tache.getCommentaire());
			tacheform.setEtat(tache.getEtat());
			tacheform.setFiche(tache.getFiche().getId());
			tacheform.setUser(tache.getUser().getId());
			tacheform.setPriorite(tache.getPriorite().getId());
			tacheform.setPiece(tache.getPiece().getId());
			tacheform.setQte(tache.getQte());
			pmodel.addAttribute("tacheform", tacheform);
		}
		return "ModifTache";
	}	
	
	@PostMapping(value="/CreerTache")
	public String creer(@Valid @ModelAttribute(name = "tacheform") TacheForm tacheform,
			BindingResult presult, Model pmodel) {
			System.out.println(pmodel);
		if(!presult.hasErrors()) {
			try
			{
				Tache tache = convertForm(tacheform);
				System.err.println(tache);
				service.creerTache(tache);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());

			}
		}
		else {
			pmodel.addAttribute("errors",presult.getAllErrors());
			pmodel.addAttribute("tacheform",tacheform);
		}
		return this.getAffiche(pmodel);
	
	}
	
	@PostMapping("/ModifierTache")
	public String modifieTache( 
			@Valid @ModelAttribute(name = "tacheform") TacheForm tacheform,
			 BindingResult presult,
			Model pmodel)
	{
			
		if(!presult.hasErrors()) {
			try
			{
				Tache tache = convertForm(tacheform);
				service.creerTache(tache);
			}
			catch(Exception e) {
				System.err.println("ERRR : "+e.getMessage()+" "+e.toString());
			}
		}

		return this.getAffiche(pmodel);
	}
	
}
