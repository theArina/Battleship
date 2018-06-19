package src;

public class Field {

    private int fieldSize;
    private int ships;
    private boolean field[][];
    private short playerField[][];

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
    public void makeField() {
        field = new boolean[fieldSize][];
        for (int i = 0; i < fieldSize; i++) {
            field[i] = new boolean[fieldSize];
        }
    }
    public void makePlayerField() {
        playerField = new short[fieldSize][];
        for (int i = 0; i < fieldSize; i++) {
            playerField[i] = new short[fieldSize];
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
        for (int i = 0; i < ships; i++) {
            s.makeShip(fieldSize, field);
        }
    }
}