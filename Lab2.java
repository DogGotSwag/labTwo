import java.util.Arrays;
import java.util.Scanner;

public class Lab2 {

    public static void main (String [] args) throws Exception {

        Scanner userInput = new Scanner(System.in);
        char startletter = '\0';
        int startnumber = -1;
        char endletter = '\0';
        int endnumber = -1;
        String userpiece = "\0";
        String usercolor = "\0";
        String columns = "abcdefgh";
        String rows = "87654321";

        while (true) {
        
            // Loop used to get users starting piece
            while (true) {
                // Loop to get users piece
                while (true) {
                    System.out.println("Please enter the piece you would like to move: (PAWN, ROOK, KNIGHT, BISHOP, QUEEN, and KING)");
                    userpiece = userInput.nextLine();

                    userpiece = userpiece.toLowerCase();
                
                    if (userpiece.equals("pawn") || userpiece.equals("rook") || userpiece.equals("knight") || userpiece.equals("bishop") || userpiece.equals("queen") || userpiece.equals("king")) {
                        break;
                    
                    }

                    else{
                        System.out.println("Error! Please enter a valid piece you would like to move: (PAWN, ROOK, KNIGHT, BISHOP, QUEEN, and KING)");
        
                    }

                }
                // Loop to get users piece color
                while (true) {
                    System.out.println("Please enter the color of your piece: (WHITE or BLACK)");
                    usercolor = userInput.nextLine();

                    usercolor = usercolor.toLowerCase();

                    if (usercolor.equals("white") || usercolor.equals("black")) {
                        break;

                    }

                    else {
                        System.out.println("Error! Please enter a valid color for your piece: (WHITE or BLACK)");

                    }

                }
                // Loop to get users piece column
                while (true) {
                    System.out.println("Please enter the column of your piece: (a - h)");
                    String userstartcol = userInput.nextLine();

                    userstartcol = userstartcol.toLowerCase();

                    if (userstartcol.length() == 1){
                        char startcol = userstartcol.charAt(0);
                            
                        if ((startcol >= 'a' && startcol <= 'h')) {
                            startletter = startcol;
                            break;

                        }

                        else {
                            System.out.println("Error! Please enter a valid column: (a - h)");
        
                        }

                    }

                    else {
                        System.out.println("Error! Please enter only one digit: (a - h)");

                    }

                }
                // Loop to get users piece row
                while (true) {
                    System.out.println("Please enter the row of your piece: (1 - 8)");
                    String userstartrow = userInput.nextLine();

                    userstartrow = userstartrow.toLowerCase();

                    if (userstartrow.length() == 1) {
                        char startrow = userstartrow.charAt(0);

                        if (Character.isDigit(startrow)) {
                            startnumber = Character.getNumericValue(startrow);

                            if (startnumber >= 1 && startnumber <= 8)
                                break;

                            else
                                System.out.println("Error! Please enter a valid row: (1 - 8)");

                        }

                        else {
                            System.out.println("Error! Please enter a valid number: (1 - 8)");
                
                        }

                    }

                    else {
                        System.out.println("Error! Please enter only one digit: (1 - 8)");
            
                    }

                }

                break;

            }
            // Loop used to get users target position
            while (true) {
                boolean possible = false;
                // Loop used to get users target position column
                while (true) {
                    System.out.println("Please enter the column of your target position: (a - h)");
                    String userendcol = userInput.nextLine();

                    userendcol = userendcol.toLowerCase();

                    if (userendcol.length() == 1){
                        char endcol = userendcol.charAt(0);
                            
                        if ((endcol >= 'a' && endcol <= 'h')) {
                            endletter = endcol;
                            break;

                        }

                        else {
                            System.out.println("Error! Please enter a valid column: (a - h)");
        
                        }

                    }

                    else {
                        System.out.println("Error! Please enter only one character: (a - h)");

                    }

                }
                // Loop used to get users target position row
                while (true) {
                    System.out.println("Please enter the row of your target position: (1 - 8)");
                    String userendrow = userInput.nextLine();

                    userendrow = userendrow.toLowerCase();

                    if (userendrow.length() == 1) {
                        char endrow = userendrow.charAt(0);

                        if (Character.isDigit(endrow)) {
                            endnumber = Character.getNumericValue(endrow);

                            if (endnumber >= 1 && endnumber <= 8)
                                break;

                            else
                                System.out.println("Error! Please enter a valid row: (1 - 8)");

                        }

                        else {
                            System.out.println("Error! Please enter a number: (1 - 8)");
                
                        }

                    }

                    else {
                        System.out.println("Error! Please enter only one digit: (1 - 8)");
            
                    }

                }

                if (startnumber == endnumber && startletter == endletter) {
                    System.out.println("Error! Your starting position and target position are the same");

                }

                else {
                    switch (userpiece) {

                        case "pawn":
                            break;

                        case "rook":
                            break;

                        case "knight":
                            break;

                        case "bishop":
                            Bishop temp = new Bishop(userpiece, usercolor, startletter, startnumber);

                            int[][] availableCoordinates = temp.verifyTarget(temp.getColumn(), temp.getRow());

                            int indexOne = rows.indexOf(String.valueOf(endnumber)); // We get the index coordinate of the move the user inputted
                            int indexTwo = columns.indexOf(endletter);

                            int [] move = {indexOne, indexTwo};

                            for (int j = 0; j < availableCoordinates.length; j++) { // We go through the available coordinates and check if the user move is in there, boolean (possible) will be changed to true if found
                                if (Arrays.equals(move, availableCoordinates[j])) {
                                    possible = true;
                                    break;
                
                                }
                
                            }

                            if (possible)
                                System.out.println(userpiece + " at " + temp.getColumn() + ", " + temp.getRow() + " can move to " + endletter + ", " + endnumber);

                            else
                                System.out.println(userpiece + " at " + temp.getColumn() + ", " + temp.getRow() + " can't move to " + endletter + ", " + endnumber);

                            break;

                        case "queen":
                            break;

                        case "king":
                            break;

                    }

                    System.out.println("Would you like to verify another position for your piece using your original position: (YES or NO)");
                    String switchtpos = userInput.nextLine();

                    switchtpos = switchtpos.toLowerCase();

                    if (switchtpos.equals("no"))
                        break;

                }

            }

            System.out.println("Would you like to select another chess piece: (YES or NO)");
            String switchpiece = userInput.nextLine();

            switchpiece = switchpiece.toLowerCase();

            if (switchpiece.equals("no"))
                break;

        }

    }

}