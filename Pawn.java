import java.util.Arrays;
import java.util.Vector;

public class Pawn {
    public String pieceName;
    public String color;
    public String column;
    public String row;

    public boolean inBounds(int[] coordinate) {
        int indexOne = coordinate[0];
        int indexTwo = coordinate[1];
        if (indexOne < 0 || indexOne > 7)
            return false;
        if (indexTwo < 0 || indexTwo > 7)
            return false;
        return true;
    }

    public int[][] vectorToArray(Vector<int[]> vector) {
        int[][] newArray = new int[vector.size()][2];
        for (int i = 0; i < vector.size(); i += 1) {
            int[] curr = { vector.get(i)[0], vector.get(i)[1] };
            newArray[i] = curr;
        }
        return newArray;
    }

    public int[][] generateCoordinates() {
        Vector<int[]> vector = new Vector<>();
        String letters = "abcdefgh";
        String numbers = "87654321";

        int rows = numbers.indexOf(this.row);
        int cols = letters.indexOf(this.column);

        int direction = (color.equals("white")) ? -1 : 1;

        // Forward move
        int[] forwardMove = { rows + direction, cols };
        if (inBounds(forwardMove)) {
            vector.add(forwardMove);
        }

        return vectorToArray(vector);
    }

    // constructor
    public Pawn() {
        this.pieceName = "Pawn";
        this.color = null;
        this.column = null;
        this.row = null;
    }

    public Pawn(String color, String col, String row) {
        this.pieceName = "Pawn";
        this.color = color.toLowerCase();
        this.column = col.toLowerCase();
        this.row = row;
    }

    public Pawn(String color, String col, String row, String pieceName) {
        this.pieceName = pieceName;
        this.color = color.toLowerCase();
        this.column = col.toLowerCase();
        this.row = row;
    }

    public void setColumn(String col) {
        this.column = col.toLowerCase();
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getColumn() {
        return this.column;
    }

    public String getRow() {
        return this.row;
    }

    public String getColor() {
        return this.color;
    }

    public boolean verifyTarget(String column, String row) {
        String letters = "abcdefgh";
        String numbers = "87654321";
        int attackRows = numbers.indexOf(row);
        int attackCols = letters.indexOf(column.toLowerCase());

        int[] attackPosition = { attackRows, attackCols };
        int[][] availableCoordinates = this.generateCoordinates();

        for (int i = 0; i < availableCoordinates.length; i += 1) {
            int[] curr = availableCoordinates[i];
            if (Arrays.equals(curr, attackPosition)) {
                return true;
            }
        }
        return false;
    }

    // main will be used test your available coordinates output
    // public static void main(String[] args) {
    //     Pawn test = new Pawn("white", "g", "2");
    //     System.out.println(test.color);
    //     System.out.println(test.position);
    //     int[][] arr = test.availableCoordinates;
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.println(arr[i][0] + ", " + arr[i][1]);
    //     }
    // }
}