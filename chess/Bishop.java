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
        return true;
    }
}
