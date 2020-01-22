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

import groupe1.filrouge.controller.form.CommandePieceForm;
import groupe1.filrouge.entity.CommandePiece;
import groupe1.filrouge.entity.CommandeVehicule;
import groupe1.filrouge.entity.Piece;
import groupe1.filrouge.entity.User;
import groupe1.filrouge.service.IServiceCommandePiece;
import groupe1.filrouge.service.IServicePiece;
import groupe1.filrouge.service.IServiceUser;

@Controller
public class CommandePieceController {
	@Autowired
	IServiceCommandePiece serviceCommandePiece;
	@Autowired
	IServicePiece servicePiece;
	@Autowired
	IServiceUser serviceUser;
	
	private CommandePiece convertForm(CommandePieceForm cmdpieceform) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date madate = new Date();
		try {
			madate = sdf.parse(madate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		CommandePiece pcmdpiece = new CommandePiece();
		pcmdpiece.setId(cmdpieceform.getId());
		pcmdpiece.setQte(cmdpieceform.getQte());
		pcmdpiece.setDateCreation(madate);
		pcmdpiece.setEtat(cmdpieceform.getEtat());
		Piece ppiece = servicePiece.recherchePieceId(cmdpieceform.getId_piece());
		pcmdpiece.setPiece(ppiece);
		User puser = serviceUser.rechercheUserId(cmdpieceform.getId_user());
		pcmdpiece.setUser(puser);
		return pcmdpiece;
	}
	
	@GetMapping("/afficherCreerCommandePiece")
	public String getAffiche(Model pmodel) {
		List<CommandePiece> lcmdpieces = serviceCommandePiece.list();
		List<Piece> lpieces = servicePiece.recherchePiece();
		List<User> lusers = serviceUser.rechercheUser();
		pmodel.addAttribute("listecmdpieces", lcmdpieces);
		pmodel.addAttribute("listepieces", lpieces);
		pmodel.addAttribute("listeusers", lusers);
		pmodel.addAttribute("action", "CreerCommandePiece");
		
		if(!pmodel.containsAttribute("errors")) {
			CommandePieceForm cmdpieceform = new CommandePieceForm();
			cmdpieceform.setId(0);
			pmodel.addAttribute("cmdpieceform",cmdpieceform);
		}
		
		return "commandes_piece";
	}
	
	@PostMapping("/CreerCommandePiece")
	public String ajoutCommandePiece( 
			@Valid @ModelAttribute(name = "cmdpieceform") CommandePieceForm cmdpieceform,
			BindingResult presult,
			Model pmodel)
	{
		System.err.println(presult);
		if(!presult.hasErrors()) {
			try
			{
				CommandePiece pcmdpiece = convertForm(cmdpieceform);
				serviceCommandePiece.create(pcmdpiece);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		else {
			pmodel.addAttribute("errors", presult.getAllErrors());
		}
		return this.getAffiche(pmodel);
	}
	
	@GetMapping("/SupprimerCommandePiece/{id}")
	public String getSupprimer(@PathVariable final Integer id,Model pmodel) {
		CommandePiece pcmdpiece = serviceCommandePiece.find(id);
		if(pcmdpiece != null) {
			serviceCommandePiece.delete(pcmdpiece);
		}
		return this.getAffiche(pmodel);
	}
	
	@GetMapping("/afficherModifierCommandePiece/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		CommandePiece pcmdpiece = serviceCommandePiece.find(id);
		List<Piece> lpieces = servicePiece.recherchePiece();
		List<User> lusers = serviceUser.rechercheUser();
		pmodel.addAttribute("listepieces", lpieces);
		pmodel.addAttribute("listeusers", lusers);
		pmodel.addAttribute("listecmdpieces", null);
		pmodel.addAttribute("action", "ModifierCommandePiece");
		if(pmodel.containsAttribute("cmdpieceform") == false) {
			CommandePieceForm cmdpieceform = new CommandePieceForm();
			cmdpieceform.setId(pcmdpiece.getId());
			cmdpieceform.setDateCreation(new SimpleDateFormat("yyyy-MM-dd").format(pcmdpiece.getDateCreation()));
			cmdpieceform.setId_piece(Integer.valueOf(pcmdpiece.getPiece().getId()));
			cmdpieceform.setId_user(Integer.valueOf(pcmdpiece.getUser().getId()));
			cmdpieceform.setQte(Integer.valueOf(pcmdpiece.getQte()));
			cmdpieceform.setEtat(pcmdpiece.getEtat());
			pmodel.addAttribute("cmdpieceform", cmdpieceform);
		}
		return "commandes_piece";
	}
	@GetMapping("/clotureCommandePiece/{id}")
	public String clotureCommande(Model pmodel, @PathVariable Integer id) {
		CommandePiece commande = serviceCommandePiece.find(id);
		commande.setEtat(true);
		Date date = new Date();
		commande.setDateCloture(date);
		serviceCommandePiece.update(commande);
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/ModifierCommandePiece")
	public String modifieCommandePiece(@Valid @ModelAttribute(name = "cmdpieceform") CommandePieceForm cmdpieceform, BindingResult presult, Model pmodel) {
		if(!presult.hasErrors()) {
			try
			{
				CommandePiece pcmdpiece = convertForm(cmdpieceform);
				serviceCommandePiece.update(pcmdpiece);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return this.getAffiche(pmodel);
	}

}
