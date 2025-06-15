package K08_Vererbung.Dungeons_and_Dragons;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Magician("Möhrle");
        System.out.println(p1);

        Player p2 = new Necromancer("Waldi");

        p2.fight(p1);
    }
}