package K08_Vererbung.Dungeons_and_Dragons;

public class Magician extends Player {

    Magician(String name) {
        super(name);
    }

    void fight(Player p) {
        System.out.println("Magician fights with Player '" + p.name + "'");
    }

    @Override
    public String toString() {
        return "Magician '" + name + "'";
    }
}
