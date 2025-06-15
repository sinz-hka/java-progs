package K08_Vererbung.Dungeons_and_Dragons;

abstract public class Player {
    String name;
    int level; // 1-10
    int health; // 0-100

    Player(String name) {
        this.name = name;
        level = 1;
        health = 100;
    }

    void heal(int amount) {
        health += amount;
    }

    void moveTo(/* Position p */) {
        // TODO
    }

    @Override
    public String toString() {
        return "Player '" + name + "'";
    }

    abstract void fight(Player p);
}
