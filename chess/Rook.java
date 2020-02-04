import java.lang.*;
public class Rook extends Piece{
    public Rook(PieceColour c) {
        this.colour = c;
        if(this.colour == PieceColour.WHITE)
            this.setSymbol(""+(char) 0x2656);
        else
            this.setSymbol(""+(char) 0x265C);
    }

    public boolean isLegitMove(int currentRow, int currentCol, int newRow, int newCol) {
        Square[][] board = Board.getBoard();
        boolean validMove = true;
        // there can't be any other piece in the path
        // can only move vertically or horizontally
        if(currentRow == newRow) {
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
        else {
            //moving neither horizontally nor vertically
            validMove = false;
        }
        return validMove;
    }
}
