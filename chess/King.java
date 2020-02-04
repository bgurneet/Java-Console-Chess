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

        return (Math.abs(currentRow - newRow) <= 1) && (Math.abs(currentCol - newCol) <= 1);
    }
}
