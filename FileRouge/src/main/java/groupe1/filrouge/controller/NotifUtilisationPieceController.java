package groupe1.filrouge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import groupe1.filrouge.entity.Tache;
import groupe1.filrouge.service.IServiceTache;

@Controller
public class NotifUtilisationPieceController {
	@Autowired
	IServiceTache serviceTache;
	
	@GetMapping("/afficherPiecesUtilisees")
	public String getAffiche(Model pmodel) {
		List<Tache> ltaches = serviceTache.rechercheTache();
		pmodel.addAttribute("listetache", ltaches);
		return "pieces_utilisees";
	}
}
