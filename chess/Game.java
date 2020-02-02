import java.util.*;
public class Game {
    private static boolean gameEnd=false;

    public Game(){
        Board b = new Board();
        b.initialisePieces();
        b.printBoard();
        Scanner sc = new Scanner(System.in);
        while (!gameEnd){
            //write the game logic
            System.out.println("--------- Whites move --------");
            String origin = getCoordinatesInput("> Enter Origin");
            String destination = getCoordinatesInput("> Enter Destination");
            
        }       
    }

    public static void main (String args[]){
        Game g  = new Game();
    }
    
    public static String getCoordinatesInput(String displayString) {
        Scanner sc = new Scanner(System.in);
        CheckInput checker = new CheckInput();
        String output = "";
        while(output.isEmpty()) {
            System.out.println(displayString);
            String input = sc.next();
            if(checker.checkCoordinateValidity(input))
                output = input;
            else
                System.out.println("ERROR: Please enter valid coordinates between 1a and 8h");
        }
        return output;
    }
}
