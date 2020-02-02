//This class is partially implemented 
public class Square {
    private int i;
    private int j;
    private boolean hasPiece;
    private Piece p;

    public Square(int iIn, int jIn){
        i=iIn;
        j=jIn;
    }

    public Piece getPiece() {
        // returns the piece
        return p;
    }

    public void setPiece(Piece piece) {
        // sets the local piece variable (p) to the new piece argument
        hasPiece = true;
        p = piece;
    }

    public void removePiece() {
        // empties the square by removing the piece
        hasPiece = false;
        p = null;
    }

    public boolean hasPiece(){
        return hasPiece;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
