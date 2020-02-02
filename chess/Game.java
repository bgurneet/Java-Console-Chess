
public class Game {
    private static boolean gameEnd=false;

    public Game(){
        Board b = new Board();
        b.initialisePieces();
        b.printBoard();
        while (!gameEnd){
            //write the game logic
            
        }		
    }

    public static void main (String args[]){
        Game g  = new Game();
    }
}
