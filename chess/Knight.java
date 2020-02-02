 

public class Knight extends Piece{
    
    public Knight(PieceColour c) {
        this.colour = c;
        if(this.colour == PieceColour.WHITE)
            this.setSymbol(""+(char) 0x2658);
        else
            this.setSymbol(""+(char) 0x265E);
    }

}
