package src;

public class Field {

    private int fieldSize;
    private int ships;
    private boolean field[][];
    private char playerField[][];
    private int coordinatesX[];
    private int coordinatesY[];
    private boolean dirs[];

    public void setFieldSize(int size) {
        fieldSize = size;
    }
    public int getFieldSize() {
        return fieldSize;
    }
    public void setShips(int num) {
        ships = num;
    }
    public int getShips() {
        return ships;
    }
    public int[] coordinatesX() {
        return coordinatesX;
    }
    public int[] coordinatesY() {
        return coordinatesY;
    }
    public boolean[][] getField() {
        return field;
    }
    public char[][] getPlayerField() {
        return playerField;
    }
    public void makeField() {
        field = new boolean[fieldSize][];
        for (int i = 0; i < fieldSize; i++) {
            field[i] = new boolean[fieldSize];
        }
    }
    public void makePlayerField() {
        playerField = new char[fieldSize][];
        for (int i = 0; i < fieldSize; i++) {
            playerField[i] = new char[fieldSize];
            for (int j = 0; j < fieldSize; j++) {
                playerField[i][j] = '-';
            }
        }
    }

    public void showField(String fieldType) {
        System.out.print("    ");
        for (int p = 0; p < fieldSize; p++) {
            System.out.print((char)(p + 65) + "  ");
        }
        System.out.println("\n");
        for (int i = 0; i < fieldSize; i++) {
            System.out.print(i + "   ");

            if (fieldType == "full") {
                for (int j = 0; j < fieldSize; j++) {
                    System.out.print((field[i][j] ? 1 : 0) + "  ");
                }
            } else if (fieldType == "current"){
                for (int j = 0; j < fieldSize; j++) {
                    System.out.print(playerField[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
    public void makeShips(Ship s) {
        coordinatesX = new int[ships];
        coordinatesY = new int[ships];
        dirs = new boolean[ships];
        for (int i = 0; i < ships; i++) {
            dirs[i] = s.makeShip(fieldSize, field);
            coordinatesX[i] = s.getX();
            coordinatesY[i] = s.getY();
        }
    }
}