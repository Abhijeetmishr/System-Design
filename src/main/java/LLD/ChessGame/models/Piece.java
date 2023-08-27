package LLD.ChessGame.models;

import java.util.List;

public class Piece {
    PieceType pieceType;
    PieceColor pieceColor;
    boolean isKilled = false;
    int numOfMoves = 0;
    // List<PossibleMovesProvider> possibleMovesProvider;
    Cell currentCell;
    
    // public Piece(PieceType pieceType, PieceColor pieceColor, boolean isKilled, int numOfMoves,
    //         List<PossibleMovesProvider> possibleMovesProvider, Cell currentCell) {
    //     this.pieceType = pieceType;
    //     this.pieceColor = pieceColor;
    //     this.isKilled = isKilled;
    //     this.numOfMoves = numOfMoves;
    //     this.possibleMovesProvider = possibleMovesProvider;
    //     this.currentCell = currentCell;
    // }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean isKilled) {
        this.isKilled = isKilled;
    }

    public int getNumOfMoves() {
        return numOfMoves;
    }

    public void setNumOfMoves(int numOfMoves) {
        this.numOfMoves = numOfMoves;
    }

    // public List<PossibleMovesProvider> getPossibleMovesProvider() {
    //     return possibleMovesProvider;
    // }

    // public void setPossibleMovesProvider(List<PossibleMovesProvider> possibleMovesProvider) {
    //     this.possibleMovesProvider = possibleMovesProvider;
    // }

    public Cell getCurrentCell() {
        return currentCell;
    }

    public void setCurrentCell(Cell currentCell) {
        this.currentCell = currentCell;
    }

}
