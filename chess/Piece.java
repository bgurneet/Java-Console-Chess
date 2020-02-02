import java.lang.*;
public class Piece {
    private int row;
    private int column;
    private String symbol;
    protected PieceColour colour;

    public Piece() {
        
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String newSymbol) {
        symbol = newSymbol;
    }

    public PieceColour getColour() {
        return colour;
    }

    public void updateCoordinates(int r, int c) {
        row = r;
        column = c;
    }

    public boolean isLegitMove(int currentRow, int currentCol, int newRow, int newCol) {
        //TODO: write logic for this method
        Square[][] board = Board.getBoard();
        boolean validMove = true;
        if((symbol.equals(""+(char) 0x265C)) || (symbol.equals(""+(char) 0x2656))) {
            // movement for a rook
            // there can't be any other piece in the path
            // can only move vertically or horizontally
            if(currentRow == newRow) {
                // moving horizontally
                for(int j=currentCol;j<newCol;j++) {
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
        }
        return validMove;
    }

}