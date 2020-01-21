package groupe1.filrouge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipios.springsearch.anotation.SearchSpec;

import groupe1.filrouge.dao.PieceDao;
import groupe1.filrouge.dao.VehiculeDao;
import groupe1.filrouge.entity.Piece;
import groupe1.filrouge.entity.Vehicule;

@RestController
@RequestMapping("/Rest/entity")
public class Search {

	@Autowired
	PieceDao daopiece;

	@Autowired
	VehiculeDao daovoiture;

	@GetMapping("/SearchPiece")
	public List<Piece> searchPiece(@SearchSpec Specification<Piece> specs) {
		return daopiece.findAll(Specification.where(specs));
	}

	@GetMapping("/SearchVoiture")
	public List<Vehicule> searchVoiture(@SearchSpec Specification<Vehicule> specs) {
		return daovoiture.findAll(Specification.where(specs));
	}

}
