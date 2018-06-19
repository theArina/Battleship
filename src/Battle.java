package src;
import java.util.Scanner;

public class Battle {

    public void greeting(Field f, int fieldSize, int ships, int shipSize) {
        String greet = "Hello and welcome to the Battleship!";
        String rules = "Now you will guess where the ships are. " +
                "Type a coordinate from A0 to " + (char)(fieldSize + 64) + (fieldSize - 1) +
                ". You can \"miss\" \"hit a ship\" or \"sank a ship\".\n" +
                "There are " + ships + " ships of " + shipSize + " units.\n" +
                "Here is the field without ships.";
        System.out.println(greet + "\n" + rules + "\n");
        f.showField("current");
        System.out.println("\nWe are ready to start.\n");
    }
    public void battle() {
        Scanner scan = new Scanner(System.in);
        String coordinate = scan.next();
    }
}