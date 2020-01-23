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

import groupe1.filrouge.controller.form.ClientForm;
import groupe1.filrouge.entity.Client;
import groupe1.filrouge.service.IServiceClient;

@Controller
public class ClientController {
	@Autowired
	private IServiceClient service;
	
	private Client convertForm(ClientForm clientform) throws Exception{
		Client pclient = new Client();
		pclient.setId(clientform.getId());
		pclient.setFirstname(clientform.getFirstname());
		pclient.setName(clientform.getName());	
		pclient.setAdresse(clientform.getAdresse());
		pclient.setCodePostal(clientform.getCodePostal());
		pclient.setMobile(clientform.getMobile());
		pclient.setTelephone(clientform.getTelephone());
		pclient.setVille(clientform.getVille());
		pclient.setCloturer(clientform.getCloturer());
		return pclient;
	}
	
	@GetMapping("/afficherCreerClient")
	public String getAffiche(Model pModel ) {
		List<Client> lclient = service.list();
		pModel.addAttribute("listeclient", lclient);	
		
		pModel.addAttribute("action", "CreerClient");
		if(!pModel.containsAttribute("errors")){
			ClientForm clientform = new ClientForm();
			clientform.setId(0);
			pModel.addAttribute("clientform", clientform);
		}
		return "clients";
	}	
	

	
	@GetMapping("/afficherModifierClient/{id}")
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
			clientform.setCodePostal(client.getCodePostal());
			clientform.setMobile(client.getMobile());
			clientform.setTelephone(client.getTelephone());	
			clientform.setCloturer(client.getCloturer());
			pmodel.addAttribute("clientform", clientform);
		}
		return "clients";
	}	
	
	@PostMapping(value="/CreerClient")
	public String creer(@Valid @ModelAttribute(name = "clientform") ClientForm clientform,
			BindingResult presult, Model pmodel) {
			System.out.println(pmodel);
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
		else {
			pmodel.addAttribute("errors",presult.getAllErrors());
			pmodel.addAttribute("clientform",clientform);
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
		else {
			pmodel.addAttribute("errors",presult.getAllErrors());
			pmodel.addAttribute("clientform",clientform);
			return this.getAfficheMod(clientform.getId(), pmodel);
		}
		return this.getAffiche(pmodel);
	}
	
	
}
