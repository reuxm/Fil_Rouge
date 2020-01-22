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
import groupe1.filrouge.controller.form.PieceForm;
import groupe1.filrouge.entity.Piece;
import groupe1.filrouge.service.IServicePiece;

@Controller
public class PieceController {
	@Autowired
	private IServicePiece servicePiece;
	
	private Piece convertForm(PieceForm pieceform) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date madate = sdf.parse(pieceform.getDateCreation());		
		Piece ppiece = new Piece();
		ppiece.setId(pieceform.getId());
		ppiece.setLibelle(pieceform.getLibelle());
		ppiece.setQte(Integer.valueOf(pieceform.getQte()));
		ppiece.setDateCreation(madate);
		return ppiece;
	}
	
	@GetMapping("/afficherCreerPiece")
	public String getAffiche(Model pmodel) {
		List<Piece> lPieces = servicePiece.recherchePiece();
		pmodel.addAttribute("listepiece", lPieces);
		pmodel.addAttribute("action", "CreerPiece");
		
		if(!pmodel.containsAttribute("errors")) {
			PieceForm pieceform = new PieceForm();
			pieceform.setId(0);
			Date dateJour = new Date();
			pieceform.setDateCreation(new SimpleDateFormat("yyyy-MM-dd").format(dateJour));
			pmodel.addAttribute("pieceform",pieceform);
		}
		
		return "pieces";
	}

	@GetMapping("/afficherModifierPiece/{id}")
	public String getAfficheMod(@PathVariable final Integer id,Model pmodel) {
		Piece ppiece = servicePiece.recherchePieceId(id);
		pmodel.addAttribute("listepiece", null);
		pmodel.addAttribute("action", "ModifierPiece");
		if(pmodel.containsAttribute("pieceform") == false) {
			PieceForm pieceform = new PieceForm();
			pieceform.setId(ppiece.getId());
			pieceform.setLibelle(ppiece.getLibelle());
			pieceform.setQte(ppiece.getQte());
			pieceform.setDateCreation(new SimpleDateFormat("yyyy-MM-dd").format(ppiece.getDateCreation()));
			pmodel.addAttribute("pieceform", pieceform);
		}
		return "pieces";
	}
	
	@GetMapping("/SupprimerPiece/{id}")
	public String getSupprimer(@PathVariable final Integer id,Model pmodel) {
		Piece ppiece = servicePiece.recherchePieceId(id);
		if(ppiece  != null) {
			servicePiece.supprimerPiece(ppiece);;
		}
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/CreerPiece")
	public String ajoutPiece( 
			@Valid @ModelAttribute(name = "pieceform") 
			PieceForm pieceform,
			BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Piece ppiece = convertForm(pieceform);
				servicePiece.creerPiece(ppiece);
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		else
		{
			System.err.println(presult);
			pmodel.addAttribute("errors", presult.getAllErrors());
		}
		return this.getAffiche(pmodel);
	}
	
	@PostMapping("/ModifierPiece")
	public String modifiePiece( 
			@Valid @ModelAttribute(name = "pieceform") 
			PieceForm pieceform,
			 BindingResult presult,
			Model pmodel)
	{
		if(!presult.hasErrors()) {
			try
			{
				Piece ppiece = convertForm(pieceform);
				servicePiece.modifierPiece(ppiece);	

			}
			catch(Exception e) {
				System.err.println(e.getMessage());
				pmodel.addAttribute("errors", presult.getAllErrors());
				pmodel.addAttribute("pieceform",pieceform);
				return this.getAfficheMod(pieceform.getId(), pmodel);
			}
		}
		else {
			System.err.println(presult);
			pmodel.addAttribute("errors", presult.getAllErrors());
			return this.getAfficheMod(pieceform.getId(), pmodel);
		}
		
		return this.getAffiche(pmodel);
	}
	
}
