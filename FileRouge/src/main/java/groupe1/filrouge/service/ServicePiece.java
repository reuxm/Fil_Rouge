package groupe1.filrouge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import groupe1.filrouge.dao.PieceDao;
import groupe1.filrouge.entity.Piece;

@Service
public class ServicePiece implements IServicePiece {
	@Autowired
	PieceDao dao;

	@Transactional(readOnly = true)
	@Override
	public List<Piece> recherchePiece() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Piece recherchePieceId(int id) {
		return dao.findById(id).get();
	}

	@Transactional
	@Override
	public void creerPiece(Piece pPiece) {
		dao.save(pPiece);
	}

	@Transactional
	@Override
	public void modifierPiece(Piece pPiece) {
		dao.save(pPiece);
	}

	@Transactional
	@Override
	public void supprimerPiece(Piece pPiece) {
		dao.deleteById(pPiece.getId());
	}

}
