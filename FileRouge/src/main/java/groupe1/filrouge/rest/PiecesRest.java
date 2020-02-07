package groupe1.filrouge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import groupe1.filrouge.entity.Piece;
import groupe1.filrouge.service.IServicePiece;

@RestController
@RequestMapping("/Rest/entity")
public class PiecesRest {
	
	@Autowired
	private IServicePiece spiece;
	
	@GetMapping("/pieces")
	public List<Piece> listpieces() {
		return spiece.recherchePiece();
	}

}
