package groupe1.filrouge.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sipios.springsearch.anotation.SearchSpec;

import groupe1.filrouge.dao.PieceDao;
import groupe1.filrouge.dao.VehiculeDao;
import groupe1.filrouge.entity.Piece;
import groupe1.filrouge.entity.Vehicule;

@RestController
@RequestMapping("/")
public class Search {
	
	@Autowired
	PieceDao daopiece;
	
	@Autowired
	VehiculeDao daovoiture;
	
	@GetMapping("/SearchPiece")
    public ResponseEntity<List<Piece>> searchPiece(@SearchSpec Specification<Piece> specs) {
        return new ResponseEntity<>(daopiece.findAll(Specification.where(specs)), HttpStatus.OK);
    }
	
	@GetMapping("/SearchVoiture")
    public ResponseEntity<List<Vehicule>> searchVoiture(@SearchSpec Specification<Vehicule> specs) {
        return new ResponseEntity<>(daovoiture.findAll(Specification.where(specs)), HttpStatus.OK);
    }

}
