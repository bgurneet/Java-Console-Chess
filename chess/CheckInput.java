
public class CheckInput {

    public boolean checkCoordinateValidity(String input){
        if (input.length() == 2) {
            input = input.toLowerCase();
            int row = 0, col = 0;
            if(Character.isDigit(input.charAt(0)))
                row = Character.getNumericValue(input.charAt(0));
            if(Character.isLetter(input.charAt(1)))
                col = input.charAt(1);
            return (row > 0) && (row < 9) && (col >= 'a') && (col <= 'h');
        }
        return false;
    }
    
    public boolean endGame(String input) {
        return input.toLowerCase().equals("end");
    }
}
