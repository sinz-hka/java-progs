package K08_Vererbung.Dungeons_and_Dragons;

public class Necromancer extends Magician {
    Necromancer(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Necromancer '" + name + "'";
    }

    @Override
    void fight(Player p) {
        System.out.println("Necromancer '" + name + "' fights with Player '" + p.name + "'");
    }
}
