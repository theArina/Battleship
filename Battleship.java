import src.*;

public class Battleship {
    public static void main (String[] args) {

        Field f = new Field();
        f.setFieldSize(7);
        f.makeField();
        f.makePlayerField();

        Ship s = new Ship();
        s.setShipSize(3);
        f.setShips(3);
        f.makeShips(s);

        f.showField("full");

        Battle b = new Battle();
        b.greeting(f, f.getFieldSize(), f.getShips(), s.getShipSize());
        b.battle(f, f.getFieldSize());

    }
}