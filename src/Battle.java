package src;
import java.util.Scanner;

public class Battle {

    public void greeting(Field f, int shipSize) {
        String greet = "\nHello and welcome to the Battleship!";
        String rules = "Now you will guess where the ships are. " +
                "Type a coordinate from A0 to " + (char)(f.getFieldSize() + 64) + (f.getFieldSize() - 1) +
                ". You can \"miss\" \"hit a ship\" or \"sank/kill a ship\".\n" +
                "There are " + f.getShips() + " ships of " + shipSize + " units.\n" +
                "Here is the field without ships.";
        System.out.println(greet + "\n" + rules + "\n");
        f.showField("current");
        System.out.println("\nWe are ready to start.\nType coordinate here:");
    }
    public int strokeResult(int x, int y, char[][] field, int shipSize, int fieldSize) {
        int k = 1;
        if (x + 1 < fieldSize && field[x + 1][y] == '1' ||
                x - 1 >= 0 && field[x - 1][y] == '1') {
            int j = 0;
            for (; j < shipSize; j++) {
                if (x + 1 + j < fieldSize && field[x + 1 + j][y] == '1') {
                    k++;
                } else {
                    break;
                }
            }
            j = 0;
            for (int xTemp = x + j; j < shipSize; j++) {
                if (xTemp - 1 - j >= 0 && field[xTemp - 1 - j][y] == '1') {
                    k++;
                } else {
                    break;
                }
            }
        } else {
            int j = 0;
            for (; j < shipSize; j++) {
                if (y + 1 + j < fieldSize && field[x][y + 1 + j] == '1') {
                    k++;
                } else {
                    break;
                }
            }
            j = 0;
            for (int yTemp = y + j; j < shipSize; j++) {
                if (yTemp - 1 - j >= 0 && field[x][yTemp - 1 - j] == '1') {
                    k++;
                } else {
                    break;
                }
            }
        }
        return k;
    }
    public boolean stroke(Field f, Ship s) {
        Scanner scan = new Scanner(System.in);

        String coordinateS = scan.next(); //todo limit
        char[] coordinateC = coordinateS.toCharArray();
        int y = coordinateC[0] - 65 < f.getFieldSize() ? (coordinateC[0] - 65) : (coordinateC[0] - 97);
        int x = coordinateC[1] - 48;
        boolean coordinate = f.getField()[x][y];

        if (coordinate) {
            if (strokeResult(x, y, f.getPlayerField(), s.getShipSize(), f.getFieldSize()) == s.getShipSize()) {
                System.out.println("Killed!\n");
                f.getPlayerField()[x][y] = '1';
                f.showField("current");
                return true;
            } else {
                System.out.println("Hit!\n");
                f.getPlayerField()[x][y] = '1';
                f.showField("current");
            }
        } else {
            System.out.println("Miss:(\n");
            f.getPlayerField()[x][y] = '0';
            f.showField("current");
        }
        return false;
    }
    public void battle(Field f, Ship s) {
        int  numOfHits = 0, killedShips = 0;
        for (; killedShips < f.getShips();numOfHits++) {
            killedShips+= stroke(f, s) ? 1 : 0;
        }
        System.out.println("\nTHE GAME IS OVER");
        System.out.println("You've finished with " + numOfHits +
                " hits where " + (numOfHits - killedShips * s.getShipSize()) + " is missed");
    }
}