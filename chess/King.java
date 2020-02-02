
public class King extends Piece{
    
    public King(PieceColour c) {
        this.colour = c;
        if(this.colour == PieceColour.WHITE)
            this.setSymbol(""+(char) 0x2654);
        else
            this.setSymbol(""+(char) 0x265A);
    }

}
