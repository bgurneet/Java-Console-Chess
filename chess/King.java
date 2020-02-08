import java.lang.*;
public class King extends Piece{
    
    public King(PieceColour c) {
        this.colour = c;
        if(this.colour == PieceColour.WHITE)
            this.setSymbol(""+(char) 0x2654);
        else
            this.setSymbol(""+(char) 0x265A);
    }

    public boolean isLegitMove(int currentRow, int currentCol, int newRow, int newCol) {
        // can only move one block in any direction
        // this means that the absolute value of the difference between values can be at most 1
        Square[][] board = Board.getBoard();
        boolean validMove = true;
        Square originSquare = board[currentRow][currentCol];
        Square destinationSquare = board[newRow][newCol];

        if(!((originSquare.hasPiece()) && (originSquare.getPiece().getColour() == this.colour))) {
            validMove = false;
        }
        else if((destinationSquare.hasPiece()) && (destinationSquare.getPiece().getColour() == this.colour)) {
            validMove = false;
        }
        else {
            validMove = (Math.abs(currentRow - newRow) <= 1) && (Math.abs(currentCol - newCol) <= 1);
        }

        return validMove;
    }
}
