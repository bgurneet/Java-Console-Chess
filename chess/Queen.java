
public class Queen extends Piece {
    
    public Queen(PieceColour c) {
        this.colour = c;
        if(this.colour == PieceColour.WHITE)
            this.setSymbol(""+(char) 0x2655);
        else
            this.setSymbol(""+(char) 0x265B);
    }
    
    public boolean isLegitMove(int currentRow, int currentCol, int newRow, int newCol) {
        Square[][] board = Board.getBoard();
        boolean validMove = true;
        Square originSquare = board[currentRow][currentCol];
        Square destinationSquare = board[newRow][newCol];
        // cannot pass through pieces
        // movement is an amalgation of that of a rook and bishop

        if(!((originSquare.hasPiece()) && (originSquare.getPiece().getColour() == this.colour))) {
            validMove = false;
        }
        else if((destinationSquare.hasPiece()) && (destinationSquare.getPiece().getColour() == this.colour)) {
            validMove = false;
        }
        else if((currentRow == newRow) && (currentCol == newCol)) {
            validMove = false;
        }
        else if(currentRow == newRow) {
            // moving horizontally
            int min = Math.min(currentCol, newCol);
            int max = Math.max(currentCol, newCol);
            //TODO: err - 1a to 1h works for some reason
            for(int j=min+1;j<max;j++) {
                if(board[currentRow][j].hasPiece()) {
                    validMove = false;
                    break;
                }
            }
        }
        else if(currentCol == newCol) {
            // moving vertically
            int min = Math.min(currentRow, newRow);
            int max = Math.max(currentRow, newRow);
            for(int i=min+1;i<max;i++) {
                if(board[i][currentCol].hasPiece()) {
                    validMove = false;
                    break;
                }
            }
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
