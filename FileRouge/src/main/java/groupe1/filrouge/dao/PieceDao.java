package groupe1.filrouge.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import groupe1.filrouge.entity.Piece;

public interface PieceDao extends JpaRepository<Piece, Integer> {

}
