 

public class Knight extends Piece{
    
    public Knight(PieceColour c) {
        this.colour = c;
        if(this.colour == PieceColour.WHITE)
            this.setSymbol(""+(char) 0x2658);
        else
            this.setSymbol(""+(char) 0x265E);
    }

    public boolean isLegitMove(int currentRow, int currentCol, int newRow, int newCol) {
        // can cross over pieces
        // either the x distance must be two and y one
        // or the y distance must be two and x one
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
            int x_distance = Math.abs(currentRow - newRow);
            int y_distance = Math.abs(currentCol - newCol);
            validMove = ((x_distance == 2) && (y_distance == 1)) || ((x_distance == 1) && (y_distance == 2));
        }
        return validMove;
    }
}
