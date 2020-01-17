package groupe1.filrouge.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



import groupe1.filrouge.controller.form.ClientForm;
import groupe1.filrouge.entity.Client;
import groupe1.filrouge.service.IServiceClient;

@Controller
public class ClientController {
	@Autowired
	private IServiceClient service;
	
	private Client convertForm(ClientForm clientform) {
		Client pclient = new Client();
		pclient.setId(clientform.getId());
		pclient.setFirstname(clientform.getFirstname());
		pclient.setName(clientform.getName());	
		pclient.setAdresse(clientform.getAdresse());
		pclient.setCodepostal(clientform.getCodePostal());
		pclient.setMobile(clientform.getMobile());
		pclient.setTelephone(clientform.getTelephone());
		pclient.setVille(clientform.getVille());
		return pclient;
	}
	
	@GetMapping("/afficherClient")
	public String getAffiche(Model pmodel) {
		List<Client> lclient = service.list();
		pmodel.addAttribute("listeclient", lclient);		
		return "client";
	}
	
	@RequestMapping(value="/creerFormClient")
	public String affFormCreation(final ModelMap pModel) {
		pModel.addAttribute("clientform", new ClientForm());
		pModel.addAttribute("action", "CreerClient");
		return "creationClient";
	}

	
	@GetMapping("/modifFormClient/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Client client = service.find(id);
		pmodel.addAttribute("listeclient", null);
		pmodel.addAttribute("action", "ModifierClient");
		if(pmodel.containsAttribute("clientform") == false) {
			ClientForm clientform = new ClientForm();
			clientform.setId(client.getId());
			clientform.setAdresse(client.getAdresse());
			clientform.setFirstname(client.getFirstname());
			clientform.setName(client.getName());
			clientform.setVille(client.getVille());
			clientform.setCodePostal(client.getCodepostal());
			clientform.setMobile(client.getMobile());
			clientform.setTelephone(client.getTelephone());	
			clientform.setCloturer(client.getCloturer().toString());
			pmodel.addAttribute("clientform", clientform);
		}
		return "client";
	}	
	
	@RequestMapping(value="/creerClient")
	public String creer(@Valid @ModelAttribute(name = "clientform") ClientForm clientform,
			BindingResult presult, Model pmodel) {
		
		if(!presult.hasErrors()) {
			try
			{
				Client client = convertForm(clientform);
				service.create(client);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	
	}
	@PostMapping("/ModifierClient")
	public String modifieClient( 
			@Valid @ModelAttribute(name = "clientform") ClientForm clientform,
			 BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Client client = convertForm(clientform);
				service.create(client);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}
	
	
}
