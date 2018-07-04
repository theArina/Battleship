package src;
import java.util.Random;

public class Ship {

    private int shipSize;
    private int x, y;

    public void setShipSize(int size) {
        shipSize = size;
    }
    public int getShipSize() {
        return shipSize;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    private void setCoordinates(int boundX, int boundY) {
        x = (new Random().nextInt(boundX));
        y = (new Random().nextInt(boundY));
    }
    public boolean makeShip(int fieldSize, boolean field[][]) {
        boolean dir = (new Random().nextBoolean());
        int boundX = dir ? fieldSize - shipSize : fieldSize;
        int boundY = !dir ? fieldSize - shipSize : fieldSize;
        setCoordinates(boundX, boundY);

        while (true) {
            boolean b = false;
            if ((x > 0 && field[x - 1][y]) || (y > 0 && field[x][y - 1])) {
                setCoordinates(boundX, boundY);
                continue;
            }
            for (int j = 0, xTemp = x, yTemp = y; j < shipSize; j++) {
                if (field[xTemp][yTemp] ||
                        (xTemp + 1 < fieldSize && field[xTemp + 1][yTemp]) ||
                        (yTemp + 1 < fieldSize && field[xTemp][yTemp + 1])) {
                    b = true;
                    break;
                }
                if (dir) {
                    if (yTemp - 1 > 0 && field[xTemp][yTemp - 1]) {
                        b = true;
                        break;
                    }
                    xTemp++;
                } else {
                    if (xTemp - 1 > 0 && field[xTemp - 1][yTemp]) {
                        b = true;
                        break;
                    }
                    yTemp++;
                }
            }
            if (b) {
                setCoordinates(boundX, boundY);
            } else {
                for (int j = 0; j < shipSize; j++) {
                    field[x][y] = true;
                    if (dir) {
                        x++;
                    } else {
                        y++;
                    }
                }
                break;
            }
        }
        return dir;
    }
}