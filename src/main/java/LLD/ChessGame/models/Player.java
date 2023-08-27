package LLD.ChessGame.models;

import java.util.List;

public abstract class Player {
    List<Piece> pieces;

    public Player(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    // abstract public PlayerMove makeMove();
}
