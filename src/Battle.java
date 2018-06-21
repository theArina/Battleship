package src;
import java.util.Scanner;

public class Battle {

    public void greeting(Field f, int fieldSize, int ships, int shipSize) {
        String greet = "\nHello and welcome to the Battleship!";
        String rules = "Now you will guess where the ships are. " +
                "Type a coordinate from A0 to " + (char)(fieldSize + 64) + (fieldSize - 1) +
                ". You can \"miss\" \"hit a ship\" or \"sank a ship\".\n" +
                "There are " + ships + " ships of " + shipSize + " units.\n" +
                "Here is the field without ships.";
        System.out.println(greet + "\n" + rules + "\n");
        f.showField("current");
        System.out.println("\nWe are ready to start.\nType coordinate here:");
    }
    public void battle(Field f, int fieldSize) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            String coordinateS = scan.next(); //todo limit
            char[] coordinateC = coordinateS.toCharArray();
            char y = coordinateC[0] - 65 < fieldSize ? (char)(coordinateC[0] - 65) : (char)(coordinateC[0] - 97);

            if (f.getField()[coordinateC[1] - 48][(int)y]) {
                System.out.println("Hit!");
                f.getPlayerField()[coordinateC[1] - 48][(int)y] = '1';
                f.showField("current");
            } else {
                System.out.println("Miss:(");
                f.getPlayerField()[coordinateC[1] - 48][(int)y] = '0';
                f.showField("current");
            }
        }
    }
}