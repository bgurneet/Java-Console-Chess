
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

        Rook blackRook = new Rook();
        blackRook.colour = PieceColour.BLACK;
        blackRook.setSymbol(""+(char) 0x265C);
        setPiece(0, 0, blackRook);
        setPiece(0, 7, blackRook);

        Knight blackKnight = new Knight();
        blackKnight.colour = PieceColour.BLACK;
        blackKnight.setSymbol(""+(char) 0x265E);
        setPiece(0, 1, blackKnight);
        setPiece(0, 6, blackKnight);

        Bishop blackBishop = new Bishop();
        blackBishop.colour = PieceColour.BLACK;
        blackBishop.setSymbol(""+(char) 0x265D);
        setPiece(0, 2, blackBishop);
        setPiece(0, 5, blackBishop);

        Queen blackQueen = new Queen();
        blackQueen.colour = PieceColour.BLACK;
        blackQueen.setSymbol(""+(char) 0x265B);
        setPiece(0, 3, blackQueen);

        King blackKing = new King();
        blackKing.colour = PieceColour.BLACK;
        blackKing.setSymbol(""+(char) 0x265A);
        setPiece(0, 4, blackKing);

        Pawn blackPawn = new Pawn();
        blackPawn.colour = PieceColour.BLACK;
        blackPawn.setSymbol(""+(char) 0x265F);
        for(int i=0;i<board[1].length;i++)
            setPiece(1, i, blackPawn);

        Rook whiteRook = new Rook();
        whiteRook.colour = PieceColour.WHITE;
        whiteRook.setSymbol(""+(char) 0x2656);
        setPiece(7, 0, whiteRook);
        setPiece(7, 7, whiteRook);

        Knight whiteKnight = new Knight();
        whiteKnight.colour = PieceColour.WHITE;
        whiteKnight.setSymbol(""+(char) 0x2658);
        setPiece(7, 1, whiteKnight);
        setPiece(7, 6, whiteKnight);

        Bishop whiteBishop = new Bishop();
        whiteBishop.colour = PieceColour.WHITE;
        whiteBishop.setSymbol(""+(char) 0x2657);
        setPiece(7, 2, whiteBishop);
        setPiece(7, 5, whiteBishop);

        Queen whiteQueen = new Queen();
        whiteQueen.colour = PieceColour.WHITE;
        whiteQueen.setSymbol(""+(char) 0x2655);
        setPiece(7, 3, whiteQueen);

        King whiteKing = new King();
        whiteKing.colour = PieceColour.WHITE;
        whiteKing.setSymbol(""+(char) 0x2654);
        setPiece(7, 4, whiteKing);

        Pawn whitePawn = new Pawn();
        whitePawn.colour = PieceColour.WHITE;
        whitePawn.setSymbol(""+(char) 0x2659);
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
                    System.out.print(row+" "+board[i][j].getPiece().getSymbol());  
                else if ((j==0) && !board[i][j].hasPiece())
                    System.out.print(row+"  " );
                else if (board[i][j].hasPiece())                    
                    System.out.print("|"+board[i][j].getPiece().getSymbol());                  
                else                    
                    System.out.print(" | ");     
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
