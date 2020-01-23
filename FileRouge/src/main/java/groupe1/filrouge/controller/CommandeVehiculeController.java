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

import groupe1.filrouge.controller.form.CommandeVehiculeForm;
import groupe1.filrouge.entity.CommandeVehicule;
import groupe1.filrouge.entity.Devis;
import groupe1.filrouge.entity.FactureFiche;
import groupe1.filrouge.entity.Fiche;
import groupe1.filrouge.service.IServiceCommandeVehicule;
import groupe1.filrouge.service.IServiceDevis;

@Controller
public class CommandeVehiculeController {

	@Autowired
	IServiceCommandeVehicule serviceCommandeVehicule;
	@Autowired
	IServiceDevis serviceDevis;

	private CommandeVehicule convertForm(CommandeVehiculeForm cmdvehiculeform) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date madate = new Date();
		try {
			madate = sdf.parse(madate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		CommandeVehicule pcmdvehicule = new CommandeVehicule();
		pcmdvehicule.setId(cmdvehiculeform.getId());
		pcmdvehicule.setDateCreation(madate);
		pcmdvehicule.setDateCloture(madate);
		pcmdvehicule.setEtat(false);
		pcmdvehicule.setLivre(cmdvehiculeform.getLivre());
		Devis pdevis = serviceDevis.find(cmdvehiculeform.getId_devis());
		pcmdvehicule.setDevis(pdevis);

		return pcmdvehicule;
	}

	@GetMapping("/afficherCreerCommandeVehicule")
	public String getAffiche(Model pmodel) {
		List<CommandeVehicule> lcmdvehicules = serviceCommandeVehicule.list();
		List<Devis> ldevis = serviceDevis.list();
		pmodel.addAttribute("listecmdvehicules", lcmdvehicules);
		pmodel.addAttribute("listedevis", ldevis);
		pmodel.addAttribute("veille", false);
		pmodel.addAttribute("action", "CreerCommandeVehicule");

		if (!pmodel.containsAttribute("errors")) {
			CommandeVehiculeForm cmdvehiculeform = new CommandeVehiculeForm();
			cmdvehiculeform.setId(0);
			pmodel.addAttribute("cmdvehiculeform", cmdvehiculeform);
		}
		return "commandes_vehicule";
	}
	@GetMapping("/afficherCommandeVehiculeVeille")
	public String getAfficheVeille(Model pmodel) {
		List<CommandeVehicule> lcmdvehicules = serviceCommandeVehicule.listVeille();
		List<Devis> ldevis = serviceDevis.list();
		pmodel.addAttribute("listecmdvehicules", lcmdvehicules);
		pmodel.addAttribute("listedevis", ldevis);
		pmodel.addAttribute("veille", true);
		if (!pmodel.containsAttribute("errors")) {
			CommandeVehiculeForm cmdvehiculeform = new CommandeVehiculeForm();
			cmdvehiculeform.setId(0);
			pmodel.addAttribute("cmdvehiculeform", cmdvehiculeform);
		}
		return "commandes_vehicule";
	}
	
	
	
	@PostMapping("/CreerCommandeVehicule")
	public String ajoutCommandeVehicule(
			@Valid @ModelAttribute(name = "cmdvehiculeform") CommandeVehiculeForm cmdvehiculeform,
			BindingResult presult, Model pmodel) {
		System.err.println(presult);
		if (!presult.hasErrors()) {
			try {
				CommandeVehicule pcmdvehicule = convertForm(cmdvehiculeform);
				serviceCommandeVehicule.create(pcmdvehicule);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else {
			pmodel.addAttribute("errors", presult.getAllErrors());
		}
		return this.getAffiche(pmodel);
	}

	@GetMapping("/SupprimerCommandeVehicule/{id}")
	public String getSupprimer(@PathVariable final Integer id, Model pmodel) {
		CommandeVehicule pcmdvehicule = serviceCommandeVehicule.find(id);
		if (pcmdvehicule != null) {
			serviceCommandeVehicule.delete(pcmdvehicule);
		}
		return this.getAffiche(pmodel);
	}

	@GetMapping("/afficherModifierCommandeVehicule/{id}")
	public String getAfficheMod(@PathVariable final Integer id, Model pmodel) {
		CommandeVehicule pcmdvehicule = serviceCommandeVehicule.find(id);
		List<Devis> ldevis = serviceDevis.list();
		pmodel.addAttribute("listedevis", ldevis);
		pmodel.addAttribute("listecmdvehicules", null);
		pmodel.addAttribute("action", "ModifierCommandeVehicule");
		if (pmodel.containsAttribute("cmdvehiculeform") == false) {
			
			CommandeVehiculeForm cmdvehiculeform = new CommandeVehiculeForm();

			cmdvehiculeform.setId(pcmdvehicule.getId());
			cmdvehiculeform.setDateCreation(new SimpleDateFormat("yyyy-MM-dd").format(pcmdvehicule.getDateCreation()));
			cmdvehiculeform.setDateCloture(new SimpleDateFormat("yyyy-MM-dd").format(pcmdvehicule.getDateCloture()));
			cmdvehiculeform.setId_devis(Integer.valueOf(pcmdvehicule.getDevis().getId()));
			cmdvehiculeform.setEtat(pcmdvehicule.getEtat());
			cmdvehiculeform.setLivre(pcmdvehicule.getLivre());
			pmodel.addAttribute("cmdvehiculeform", cmdvehiculeform);
		}
		return "commandes_vehicule";
	}
	@GetMapping("/clotureCommandeVehicule/{id}")
	public String clotureCommande(Model pmodel, @PathVariable Integer id) {
		CommandeVehicule commande = serviceCommandeVehicule.find(id);
		commande.setEtat( true );
		serviceCommandeVehicule.update(commande);
		return this.getAffiche(pmodel);
	}
	@GetMapping("/livreCommandeVehicule/{id}")
	public String livreCommande(Model pmodel, @PathVariable Integer id) {
		CommandeVehicule commande = serviceCommandeVehicule.find(id);
		commande.setLivre( true );
		Date date = new Date();
		commande.setDateCloture(date);
		serviceCommandeVehicule.update(commande);
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/ModifierCommandeVehicule")
	public String modifieCommandeVehicule(
			@Valid @ModelAttribute(name = "cmdvehiculeform") CommandeVehiculeForm cmdvehiculeform,
			BindingResult presult, Model pmodel) {
		if (!presult.hasErrors()) {
			try {
				CommandeVehicule pcmdvehicule = convertForm(cmdvehiculeform);
				serviceCommandeVehicule.update(pcmdvehicule);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

}
