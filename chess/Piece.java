
public abstract class Piece {
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

    public abstract boolean isLegitMove(int currentRow, int currentCol, int newRow, int newCol);

}