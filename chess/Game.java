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
            Square[][] board = b.getBoard();
            boolean whiteWins = false;
            while (true) {
                System.out.println("--------- Whites move --------");
                int[] origin = getCoordinatesInput("> Enter Origin");
                if(origin[0] == -1 && origin[1] == -1) {
                    gameEnd = true;
                    break;
                }
                Square originSquare = board[origin[0]][origin[1]];
                int[] destination = getCoordinatesInput("> Enter Destination");
                if(destination[0] == -1 && destination[1] == -1) {
                    gameEnd = true;
                    break;
                }
                Square destinationSquare = board[destination[0]][destination[1]];
                if(originSquare.hasPiece() && originSquare.getPiece().isLegitMove(origin[0], origin[1], destination[0], destination[1])) {
                    whiteWins = b.movePiece(origin[0], origin[1], destination[0], destination[1], originSquare.getPiece());
                    break;
                }
                else {
                    System.out.println("ERROR: Invalid Move!");
                }
            }
            if(gameEnd) {
                System.out.println("Game Ended!");
                break;
            }
            b.printBoard();
            if (whiteWins) {
                System.out.println("CONGRATULATIONS! The white player has won.");
                gameEnd = true;
                break;
            }
            
            board = b.getBoard();
            boolean blackWins = false;
            while (true) {
                System.out.println("--------- Blacks move --------");
                int[] origin = getCoordinatesInput("> Enter Origin");
                if(origin[0] == -1 && origin[1] == -1) {
                    gameEnd = true;
                    break;
                }
                Square originSquare = board[origin[0]][origin[1]];
                int[] destination = getCoordinatesInput("> Enter Destination");
                if(destination[0] == -1 && destination[1] == -1) {
                    gameEnd = true;
                    break;
                }
                Square destinationSquare = board[destination[0]][destination[1]];
                if(originSquare.hasPiece() && originSquare.getPiece().isLegitMove(origin[0], origin[1], destination[0], destination[1])) {
                    blackWins = b.movePiece(origin[0], origin[1], destination[0], destination[1], originSquare.getPiece());
                    break;
                }
                else {
                    System.out.println("ERROR: Invalid Move!");
                }
            }
            if(gameEnd) {
                System.out.println("Game Ended!");
                break;
            }
            b.printBoard();
            if(blackWins) {
                System.out.println("CONGRATULATIONS! The black player has won.");
                gameEnd = true;
                break;
            }
        }       
    }

    public static void main (String args[]){
        Game g  = new Game();
    }

    public static int[] getCoordinatesInput(String displayString) {
        Scanner sc = new Scanner(System.in);
        CheckInput checker = new CheckInput();
        String output = "";
        while(output.isEmpty()) {
            System.out.println(displayString);
            String input = sc.next();
            input = input.toLowerCase();
            if((checker.checkCoordinateValidity(input)) || checker.endGame(input))
                output = input;
            else
                System.out.println("ERROR: Please enter valid coordinates between 1a and 8h!");
        }
        int [] outputCoords = (output.equals("end")) ? new int[] {-1, -1} : new int[] {Character.getNumericValue(output.charAt(0)) - 1, ((int) output.charAt(1)) - ((int) 'a')};
        //int x = Character.getNumericValue(output.charAt(0)) - 1;
        //int y = ((int) output.charAt(1)) - ((int) 'a');
        return outputCoords;
    }
}
