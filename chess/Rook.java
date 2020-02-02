 

public class Rook extends Piece{
    
    public Rook(PieceColour c) {
        this.colour = c;
        if(this.colour == PieceColour.WHITE)
            this.setSymbol(""+(char) 0x2656);
        else
            this.setSymbol(""+(char) 0x265C);
    }
    
    /*public boolean isLegitMove(int i0, int j0, int i1, int j1) {
        //there should not be any pieces in the path of movement
        //can only move vertically or horizontally
        
        return false;
    }*/
}
