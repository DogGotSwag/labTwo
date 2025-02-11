import java.util.Vector;

//author Yahir Zapata

public class Bishop { // change class name
    private String piece_name;
    private String color;
    private char column;
    private int row;

    public Bishop() {

    }

    public Bishop(String bname, String bcolor, char bcolumn, int brow) {
        piece_name = bname;
        color = bcolor;
        column = bcolumn;
        row = brow;

    }

    public String getColor() {
        return color;

    }

    public char getColumn() {
        return column;

    }

    public int getRow() {
        return row;

    }

    public void setColumn(char newColumn) {
        this.column = newColumn;

    }

    public void setRow(int newRow) {
        this.row = newRow;

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

    public int[][] verifyTarget(char column, int row) {
        String columns = "abcdefgh";
        String rows = "87654321";

        String position = "" + column + row;

        Vector<int[]> vector = new Vector<>();
        int indexOne = rows.indexOf(position.split("")[1]);
        int indexTwo = columns.indexOf(position.split("")[0]);

        // Top Left
        int x = indexOne;
        int y = indexTwo;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x + 1;
            y = y - 1;

            int[] topLeft = { x, y };

            if (inBounds(topLeft) == true)
                vector.add(topLeft);

        }

        // Top Right
        x = indexOne;
        y = indexTwo;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x + 1;
            y = y + 1;

            int[] topRight = { x, y };

            if (inBounds(topRight) == true)
                vector.add(topRight);

        }

        // Bottom Left
        x = indexOne;
        y = indexTwo;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x - 1;
            y = y - 1;

            int[] bottomLeft = { x, y };

            if (inBounds(bottomLeft) == true)
                vector.add(bottomLeft);

        }

        // Bottom Right
        x = indexOne;
        y = indexTwo;

        while (x >= 0 && x <= 7 && y >= 0 && y <= 7) {
            x = x - 1;
            y = y + 1;

            int[] bottomRight = { x, y };

            if (inBounds(bottomRight) == true)
                vector.add(bottomRight);

        }

        return vectorToArray(vector);

    }

}