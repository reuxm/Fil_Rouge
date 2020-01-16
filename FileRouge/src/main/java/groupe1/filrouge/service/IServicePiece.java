package groupe1.filrouge.service;

import java.util.List;

import groupe1.filrouge.entity.Piece;

public interface IServicePiece {
	public List<Piece> recherchePiece();
	public Piece recherchePieceId(final int id);
	public void creerPiece(final Piece pPiece);
	public void modifierPiece(final Piece pPiece);
	public void supprimerPiece(final Piece pPiece);
}
