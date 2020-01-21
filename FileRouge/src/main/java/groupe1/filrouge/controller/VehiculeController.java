package groupe1.filrouge.controller;

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

import groupe1.filrouge.controller.form.VehiculeForm;
import groupe1.filrouge.entity.Vehicule;
import groupe1.filrouge.service.IServiceVehicule;

@Controller
public class VehiculeController {
	@Autowired
	IServiceVehicule serviceVehicule;
	
	private Vehicule convertForm(VehiculeForm vehiculeform) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date madate = sdf.parse(vehiculeform.getDateCreation());
		
		Vehicule pvehicule = new Vehicule();
		pvehicule.setId(vehiculeform.getId());
		pvehicule.setModele(vehiculeform.getModele());
		pvehicule.setQte(Integer.valueOf(vehiculeform.getQte()));
		pvehicule.setPrixHT(vehiculeform.getPrixHT());
		pvehicule.setDateCreation(madate);
		return pvehicule;
	}
	
	@GetMapping("/afficherCreerVehicule")
	public String getAffiche(Model pmodel) {
		List<Vehicule> lVehicules = serviceVehicule.rechercheVehicule();
		pmodel.addAttribute("listevehicule", lVehicules);
		pmodel.addAttribute("action", "CreerVehicule");
		
		if(!pmodel.containsAttribute("errors")) {
			VehiculeForm vehiculeform = new VehiculeForm();
			vehiculeform.setId(0);
			Date dateJour = new Date();
			vehiculeform.setDateCreation(new SimpleDateFormat("yyyy-MM-dd").format(dateJour));
			pmodel.addAttribute("vehiculeform",vehiculeform);
		}
		
		return "vehicules";
	}
	
	@GetMapping("/afficherModifierVehicule/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Vehicule pvehicule = serviceVehicule.rechercheVehiculeId(id);
		pmodel.addAttribute("listevehicule", null);
		pmodel.addAttribute("action", "ModifierVehicule");
		if(pmodel.containsAttribute("vehiculeform") == false) {
			VehiculeForm vehiculeform = new VehiculeForm();
			vehiculeform.setId(pvehicule.getId());
			vehiculeform.setModele(pvehicule.getModele());
			vehiculeform.setQte(pvehicule.getQte());
			vehiculeform.setPrixHT(pvehicule.getPrixHT());
			vehiculeform.setDateCreation(new SimpleDateFormat("yyyy-MM-dd").format(pvehicule.getDateCreation()));
			pmodel.addAttribute("vehiculeform", vehiculeform);
		}
		return "vehicules";
	}
	
	@GetMapping("/SupprimerVehicule/{id}")
	public String getSupprimer(@PathVariable final Integer id,Model pmodel) {
		Vehicule pvehicule = serviceVehicule.rechercheVehiculeId(id);
		if(pvehicule  != null) {
			serviceVehicule.supprimerVehicule(pvehicule);;
		}
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/CreerVehicule")
	public String ajoutVehicule( 
			@Valid @ModelAttribute(name = "vehiculeform") 
			VehiculeForm vehiculeform,
			BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Vehicule pvehicule = convertForm(vehiculeform);
				serviceVehicule.creerVehicule(pvehicule);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		else
		{
			pmodel.addAttribute("errors", presult.getAllErrors());
			System.err.println(presult);
		}
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/ModifierVehicule")
	public String modifieVehicule( 
			@Valid @ModelAttribute(name = "vehiculeform") 
			VehiculeForm vehiculeform,
			 BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Vehicule pvehicule = convertForm(vehiculeform);
				serviceVehicule.modifierVehicule(pvehicule);
				
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

}
