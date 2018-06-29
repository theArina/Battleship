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
            for (int j = 0, xTemp = x, yTemp = y; j < shipSize; j++) {
                if (field[xTemp][yTemp]) {
                    b = true;
                    break;
                }
                if (dir) {
                    xTemp++;
                } else {
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