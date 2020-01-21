package groupe1.filrouge.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import groupe1.filrouge.controller.form.DevisForm;
import groupe1.filrouge.entity.Client;
import groupe1.filrouge.entity.Devis;


import groupe1.filrouge.entity.User;
import groupe1.filrouge.entity.Vehicule;
import groupe1.filrouge.service.IServiceClient;
import groupe1.filrouge.service.IServiceDevis;
import groupe1.filrouge.service.IServiceUser;
import groupe1.filrouge.service.IServiceVehicule;

@Controller
public class DevisController {
	@Autowired
	IServiceDevis serviceDevis;
	
	@Autowired
	IServiceUser serviceUser;
	
	@Autowired
	IServiceClient serviceClient;
	
	@Autowired
	IServiceVehicule serviceVehicule;
	
	private Devis convertForm(DevisForm devisform) throws ParseException {
		Devis pdevis= new Devis();
		pdevis.setId(devisform.getId());
		
		if(devisform.getUser() != null)
		{   		
			pdevis.setClient(serviceClient.find(devisform.getClient()));
			pdevis.setUser(serviceUser.rechercheUserId(devisform.getUser()));
			pdevis.setVehicule(serviceVehicule.rechercheVehiculeId(devisform.getVehicule()));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date madate = sdf.parse(devisform.getDateCreation());	
			pdevis.setDatecreation(madate);
		}
		else
		{
			pdevis = serviceDevis.find(devisform.getId());
			
		}
		
		pdevis.setEtat(devisform.getEtat());
		System.out.println(pdevis);
		System.out.println("/////////////////////////////////////////////////////////////////////////");
		return pdevis;
	}
	
	@GetMapping("/afficherCreerDevis")
	public String getAffiche(Model pModel) {
		List<Vehicule> lvehicule = serviceVehicule.rechercheVehicule();
		List<Client> lclient = serviceClient.list();
		List<Devis> ldevis= serviceDevis.list();
		List<User> luser = serviceUser.rechercheUser();
		pModel.addAttribute("listeuser", luser);	
		pModel.addAttribute("listeclient", lclient);	
		pModel.addAttribute("listedevis", ldevis);	
		pModel.addAttribute("listevehicule", lvehicule);	
		pModel.addAttribute("action", "CreerDevis");
		if(!pModel.containsAttribute("errors")){
			DevisForm devisform = new DevisForm();
			devisform.setId(0);		
			Date dateJour = new Date();
			devisform.setDateCreation(new SimpleDateFormat("yyyy-MM-dd").format(dateJour));
			pModel.addAttribute("devisform", devisform);
		}
		return "devis";
	}
	
	@GetMapping("/afficherModifierdevis/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Devis devis = serviceDevis.find(id);
		pmodel.addAttribute("listedevis", null);
		pmodel.addAttribute("action", "ModifierDevis");
		List<Vehicule> lvehicule = serviceVehicule.rechercheVehicule();
		List<Client> lclient = serviceClient.list();
		List<Devis> ldevis= serviceDevis.list();
		List<User> luser = serviceUser.rechercheUser();
		pmodel.addAttribute("listeuser", luser);	
		pmodel.addAttribute("listeclient", lclient);	
		pmodel.addAttribute("listedevis", ldevis);	
		pmodel.addAttribute("listevehicule", lvehicule);		
		if(pmodel.containsAttribute("devisform") == false) {
			DevisForm devisform = new DevisForm();
			devisform.setId(devis.getId());
			devisform.setVehicule(devis.getVehicule().getId());
			devisform.setEtat(devis.getEtat());
			devisform.setClient(devis.getClient().getId());
			devisform.setUser(devis.getUser().getId());
			devisform.setDateCreation(new SimpleDateFormat("yyyy-MM-dd").format(devis.getDateCreation()));
			pmodel.addAttribute("devisform", devisform);
		}
		return "modifDevis";
	}	
	
	@PostMapping(value="/CreerDevis")
	public String creer(@Valid @ModelAttribute(name = "devisform") DevisForm devisform,
			BindingResult presult, Model pmodel) {
			System.out.println(pmodel);
		if(!presult.hasErrors()) {
			try
			{
				System.out.println("/////////////////////////////////////////////////////////////////////////");
				Devis devis = convertForm(devisform);
				serviceDevis.create(devis);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());

			}
		}
		else {
			pmodel.addAttribute("errors",presult.getAllErrors());
			pmodel.addAttribute("devisform",devisform);
		}
		return this.getAffiche(pmodel);
	
	}
	@PostMapping("/ModifierDevis")
	public String modifieDevis( 
			@Valid @ModelAttribute(name = "devisform") DevisForm devisform,
			 BindingResult presult,
			Model pmodel)
	{
		System.out.println("/////////////////////////////////////////////////////////////////////////");
		System.out.println(presult);
		System.out.println(devisform);	
		if(!presult.hasErrors()) {
			try
			{
				System.out.println("/////////////////////////////////////////////////////////////////////////");
				Devis devis = convertForm(devisform);
				serviceDevis.create(devis);
			}
			catch(Exception e) {
				System.err.println("ERRR : "+e.getMessage()+" "+e.toString());
			}
		}

		return this.getAffiche(pmodel);
	}
	
}

