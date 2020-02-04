
public class Queen extends Piece {
    
    public Queen(PieceColour c) {
        this.colour = c;
        if(this.colour == PieceColour.WHITE)
            this.setSymbol(""+(char) 0x2655);
        else
            this.setSymbol(""+(char) 0x265B);
    }
    
    public boolean isLegitMove(int currentRow, int currentCol, int newRow, int newCol) {
        return true;
    }
}
