package groupe1.filrouge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import groupe1.filrouge.entity.Piece;
import groupe1.filrouge.service.IServicePiece;

/**
 * Class Rest qui permet de faire le lien entre les entities et l'appli angular
 * @author Formation
 *
 */
@RestController
@RequestMapping("/Rest/entity")
public class PiecesRest {
	
	@Autowired
	private IServicePiece spiece;
	
	/**
	 * Récupération des pièces de la base de données
	 * @return liste des pièces
	 */
	@GetMapping("/pieces")
	public List<Piece> listpieces() {
		return spiece.recherchePiece();
	}
	/**
	 * Récupération d'une pièce via son id
	 * @param id
	 * @return pièce
	 */
	@GetMapping("/pieces/{id}")
	public Piece find( @PathVariable("id") int id ) {
		return spiece.recherchePieceId(id);
	}

}
