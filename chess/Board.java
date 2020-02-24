
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

        Rook blackRook = new Rook(PieceColour.BLACK);
        setPiece(0, 0, blackRook);
        setPiece(0, 7, blackRook);

        Knight blackKnight = new Knight(PieceColour.BLACK);
        setPiece(0, 1, blackKnight);
        setPiece(0, 6, blackKnight);

        Bishop blackBishop = new Bishop(PieceColour.BLACK);
        setPiece(0, 2, blackBishop);
        setPiece(0, 5, blackBishop);

        Queen blackQueen = new Queen(PieceColour.BLACK);
        setPiece(0, 3, blackQueen);

        King blackKing = new King(PieceColour.BLACK);
        setPiece(0, 4, blackKing);

        Pawn blackPawn = new Pawn(PieceColour.BLACK);
        for(int i=0;i<board[1].length;i++)
            setPiece(1, i, blackPawn);

        Rook whiteRook = new Rook(PieceColour.WHITE);
        setPiece(7, 0, whiteRook);
        setPiece(7, 7, whiteRook);

        Knight whiteKnight = new Knight(PieceColour.WHITE);
        setPiece(7, 1, whiteKnight);
        setPiece(7, 6, whiteKnight);

        Bishop whiteBishop = new Bishop(PieceColour.WHITE);
        setPiece(7, 2, whiteBishop);
        setPiece(7, 5, whiteBishop);

        Queen whiteQueen = new Queen(PieceColour.WHITE);
        setPiece(7, 3, whiteQueen);

        King whiteKing = new King(PieceColour.WHITE);
        setPiece(7, 4, whiteKing);

        Pawn whitePawn = new Pawn(PieceColour.WHITE);
        for(int i=0;i<board[6].length;i++)
            setPiece(6, i, whitePawn);

    }

    public void printBoard(){
        System.out.print("\n  a b c d e f g h \n");
        System.out.print("  -----------------\n");
        String wsp=" ";String bar="|";

        for (int i=0; i<board[0].length; i++){
            int row=i+1;
            for (int j=0; j<board[1].length; j++){
                if ((j==0) && board[i][j].hasPiece())
                    System.out.print(row+" "+getPiece(i, j).getSymbol());  
                else if ((j==0) && !board[i][j].hasPiece())
                    System.out.print(row+"  " );
                else if (board[i][j].hasPiece())                    
                    System.out.print(" | "+getPiece(i, j).getSymbol());                  
                else                    
                    System.out.print(" | ");     
            }               
            System.out.print("  "+row+"\n");
        }
        System.out.print("  -----------------");
        System.out.print("\n  a b c d e f g h \n");
    }

    public boolean movePiece(int i0, int j0, int i1, int j1, Piece p){
        boolean gamewon = false;
        if((hasPiece(i1, j1)) && ((getPiece(i1, j1).getSymbol() == ""+(char) 0x265a) || (getPiece(i1, j1).getSymbol() == ""+(char) 0x2654)))
            gamewon = true;
        board[i1][j1].setPiece(board[i0][j0].getPiece());
        board[i0][j0].removePiece();
        return gamewon;
    }

    public void setPiece(int iIn, int jIn, Piece p){
        board[iIn][jIn].setPiece(p);
    }

    public Piece getPiece(int iIn, int jIn){
        return board[iIn][jIn].getPiece();
    }

    public boolean hasPiece(int i, int j){   
        return board[i][j].hasPiece();
    }

}
