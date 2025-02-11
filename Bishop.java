import java.util.Arrays;
import java.util.Vector;

//author Yahir Zapata

public class Bishop { // change class name
    public String pieceName;
    public String color;
    public String column;
    public String row;

    public Bishop() {
        this.pieceName = "Bishop";
        this.color = null;
        this.column = null;
        this.row = null;
    }

    public Bishop(String color, String col, String row) {
        this.pieceName = "Bishop";
        this.color = color.toLowerCase();
        this.column = col.toLowerCase();
        this.row = row;
    }

    public Bishop(String color, String col, String row, String pieceName) {
        this.pieceName = pieceName;
        this.color = color.toLowerCase();
        this.column = col.toLowerCase();
        this.row = row;
    }

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

        int x = rows;
        int y = cols;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x + 1;
            y = y - 1;

            int[] topLeft = { x, y };

            if (inBounds(topLeft) == true)
                vector.add(topLeft);

        }

        // Top Right
        x = rows;
        y = cols;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x + 1;
            y = y + 1;

            int[] topRight = { x, y };

            if (inBounds(topRight) == true)
                vector.add(topRight);

        }

        // Bottom Left
        x = rows;
        y = cols;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x - 1;
            y = y - 1;

            int[] bottomLeft = { x, y };

            if (inBounds(bottomLeft) == true)
                vector.add(bottomLeft);

        }

        // Bottom Right
        x = rows;
        y = cols;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x - 1;
            y = y + 1;

            int[] bottomRight = { x, y };

            if (inBounds(bottomRight) == true)
                vector.add(bottomRight);

        }

        return vectorToArray(vector);
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
}