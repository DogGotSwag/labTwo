import java.util.Scanner;

public class labTwoDD {

    enum PieceType {
        KING,
        QUEEN,
        ROOK,
        BISHOP,
        KNIGHT,
        PAWN
    }

    enum PieceColor {
        WHITE,
        BLACK
    }

    enum Continue {
        YES,
        NO
    }

    public static String getPiece(String message, String tryAgain){
        Scanner userInput = new Scanner(System.in);
        System.out.println(message);
        String piece = userInput.nextLine().toUpperCase();
        for( PieceType myVar: PieceType.values()){
           String curr = myVar.toString();
           if(curr.equals(piece)){
            return piece;
           }
        }
        return getPiece(tryAgain, tryAgain);
    }

    public static String getColor(String message, String tryAgain){
        Scanner userInput = new Scanner(System.in);
        System.out.println(message);
        String color = userInput.nextLine().toUpperCase();
        for( PieceColor myVar: PieceColor.values()){
           String curr = myVar.toString();
           if(curr.equals(color)){
            return color;
           }
        }
        return getColor(tryAgain, tryAgain);
    }

    public static String getContinue(String message, String tryAgain){
        Scanner userInput = new Scanner(System.in);
        System.out.println(message);
        String color = userInput.nextLine().toUpperCase();
        for( Continue myVar: Continue.values()){
           String curr = myVar.toString();
           if(curr.equals(color)){
            return color;
           }
        }
        return getColor(tryAgain, tryAgain);
    }

    public static String getCoordinates(String message, String tryAgain){
        checkCoordinates coordinateCheck = new checkCoordinates();
        Scanner userInput = new Scanner(System.in);
        System.out.println(message);
        String chessCoordinates = userInput.nextLine();
        String col = chessCoordinates.split("")[0];
        String row = chessCoordinates.split("")[1];

        if(chessCoordinates.length() != 2){
           return getCoordinates("must be two characters", tryAgain);
        }

        if(coordinateCheck.withinChessBoard(col, row)){
            return chessCoordinates;
        }
        return getCoordinates(tryAgain, tryAgain);
    }

    public static void verifyTarget(String piece, String target, String color, String coordinates){
        String coordinateCol = coordinates.split("")[0];
        String coordinateRow = coordinates.split("")[1];
        String targetCol = target.split("")[0];
        String targetRow = target.split("")[1];
        switch(piece){
            case "KING":
                break;
            case "QUEEN":
                Queen realQueen = new Queen(color, coordinateCol, coordinateRow);
                boolean canAttack = realQueen.verifyTarget(targetCol, targetRow);
                 if(canAttack){
                    System.out.println("Queen at " + realQueen.getColumn() + ", " + realQueen.getRow() + " can move to " + target);
                 }else {
                    System.out.println("Queen at " + realQueen.getColumn() + ", " + realQueen.getRow() + " can not move to " + target);
                 }

                break;
            case "ROOK":
                break;
            case "Knight":
                break;
            case "PAWN":
                break;
            case "BISHOP":
                break;
        }

        String verifyAgain = getContinue("interested in verifying another target position using the same original position", "yes or no only");
        if(verifyAgain.equals("YES")){
            String newTarget = getCoordinates("target coordinates", "try again");
            verifyTarget(piece, newTarget, color, coordinates);
        }
    }

    public static void game(){
        String piece = getPiece("Which Piece", "try again");
        String color = getColor("which color", "try again");
        String coordinates = getCoordinates("chess coordinates", "try again plz");
        String target = getCoordinates("target coordinates", "try again plz");

        verifyTarget(piece, target, color, coordinates);

        String gameAgain = getContinue("interested in selecting another chess piece", "yes or no only");
        if(gameAgain.equals("YES")){
            game();
        }
        else{
            System.out.println("game terminate thanks for playing  |_(-_-)_/");
        }
    }

    public static void main(String[] args) {
        game();
    }
}