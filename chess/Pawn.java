import java.lang.*;
import java.util.*;
public class Pawn extends Piece{    

    public Pawn(PieceColour c) {
        this.colour = c;
        if(this.colour == PieceColour.WHITE)
            this.setSymbol(""+(char) 0x2659);
        else
            this.setSymbol(""+(char) 0x265F);
    }

    public boolean isLegitMove(int currentRow, int currentCol, int newRow, int newCol) {
        // cannot move backwards
        // can move one block in the forward direction only if the block is empty
        // can move two blocks if the pawn is in starting position
        // can move one block diagonally if the diagonal block has an enemy piece
        Square[][] board = Board.getBoard();
        boolean validMove = true;
        boolean allowedTwo = (((this.colour == PieceColour.WHITE) && (currentRow == 6))
        || ((this.colour == PieceColour.BLACK) && (currentRow == 1)));
        int x_distance = Math.abs(currentCol - newCol);
        int y_distance = Math.abs(currentRow - newRow);
        Set<PieceColour> colours = new HashSet<>();
        colours.add(PieceColour.WHITE);
        colours.add(PieceColour.BLACK);
        colours.remove(this.colour);
        PieceColour opponent = colours.iterator().next();
        
        if(((this.colour == PieceColour.WHITE) && (currentRow < newRow)) 
        || ((this.colour == PieceColour.BLACK) && (currentRow > newRow)))
            // piece trying to move backwards
            validMove = false;
        else if(currentCol == newCol) {
            // trying to move forwards
            if(board[newRow][newCol].hasPiece())
                validMove = false;
            else if((allowedTwo) && (y_distance > 2))
                validMove = false;
            else if((!allowedTwo) && (y_distance != 1))
                validMove = false;
        }
        else if(!((x_distance == 1) && (y_distance == 1) && (board[newRow][newCol].hasPiece()) && (board[newRow][newCol].getPiece().colour == opponent))) {
            // trying to move one block diagonally but there is no enemy piece at destination
            validMove = false;
        }
        else if((x_distance > 1) || (y_distance > 1)) {
            // trying to move more than one block diagonally
            validMove = false;
        }
        
        return validMove;
    }
}
