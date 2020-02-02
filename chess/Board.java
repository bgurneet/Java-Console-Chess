
//This class is partially implemented. Some methods need to have their body written, some other are fine as they are and other may need to be extended. 
public class Board {
    private static Square [][] board = new Square[8][8];

    public Board(){
        for (int i=0; i<board[0].length; i++){
            for (int j=0; j<board[1].length; j++)
                board[i][j]=new Square(i,j);
        }       
    }   

    public static Square[][] getBoard(){
        return board;
    }

    public void initialisePieces(){
        Piece rook = new Piece();
        rook.colour = PieceColour.BLACK;
        rook.setSymbol(""+(char) 0x265C);
        setPiece(0, 0, rook);
        setPiece(0, 7, rook);
        System.out.println(board[0][0].getPiece().getSymbol()+"here");
    }

    public void printBoard(){
        System.out.print("\n  a b c d e f g h \n");
        System.out.print("  -----------------\n");
        String wsp=" ";String bar="|";

        for (int i=0; i<board[0].length; i++){
            int row=i+1;
            for (int j=0; j<board[1].length; j++){
                if ((j==0) && board[i][j].hasPiece())
                    System.out.print(row+" "+board[i][j].getPiece().getSymbol());  
                else if ((j==0) && !board[i][j].hasPiece())
                    System.out.print(row+"  " );
                else if (board[i][j].hasPiece())                    
                    System.out.print("| "+board[i][j].getPiece().getSymbol());                  
                else                    
                    System.out.print("| ");     
            }               
            System.out.print("  "+row+"\n");
        }
        System.out.print("  -----------------");
        System.out.print("\n  a b c d e f g h \n");
        initialisePieces();
    }

    public boolean movePiece(int i0, int j0, int i1, int j1, Piece p){
        return false;
    }

    public void setPiece(int iIn, int jIn, Piece p){
        board[iIn][jIn].setPiece(p);
    }

    public Piece getPiece(int iIn, int jIn){
        return new Piece();
    }

    public boolean hasPiece(int i, int j){      
        return false;
    }

}
