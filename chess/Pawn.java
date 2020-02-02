
public class Pawn extends Piece{	

    public Pawn(PieceColour c) {
        this.colour = c;
        if(this.colour == PieceColour.WHITE)
            this.setSymbol(""+(char) 0x2659);
        else
            this.setSymbol(""+(char) 0x265F);
    }

}
