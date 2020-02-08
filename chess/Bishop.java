 import java.lang.*;
public class Bishop extends Piece{

    public Bishop(PieceColour c) {
        this.colour = c;
        if(this.colour == PieceColour.WHITE)
            this.setSymbol(""+(char) 0x2657);
        else
            this.setSymbol(""+(char) 0x265D);
    }
    
    public boolean isLegitMove(int currentRow, int currentCol, int newRow, int newCol) {
        // cannot pass through players
        // can only move diagonally -- (top left - bottom right) or (top right - bottom left)
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
        else if(!(Math.abs(currentRow - newRow) == Math.abs(currentCol - newCol))) {
            validMove = false;
        }
        else {
            int diff = Math.abs(currentRow - newRow);
            //int min = Math.min(currentRow, newRow);
            //int max = Math.max(currentRow, newRow);
            int negFactorRow = (currentRow > newRow) ? -1:1;
            int negFactorCol = (currentCol > newCol) ? -1:1;
            for(int i=1;i<diff;i++) {
                if(board[currentRow + (i * negFactorRow)][currentCol + (i * negFactorCol)].hasPiece()){
                    validMove = false;
                    break;
                }
            }
        }
        
        return validMove;
    }
}
