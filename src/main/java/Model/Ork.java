package Model;

public class Ork {
    public String name;
    public String weapon;
    public String armor;
    public String banner;
    public int strength;
    public int agility;
    public int intelligence;
    public int health;
    public String tribe;

    public Ork(String name, String weapon, String armor, String banner,
               int strength, int agility, int intelligence, int health, String tribe) {
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
        this.banner = banner;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.health = health;
        this.tribe = tribe;
    }

    @Override
    public String toString() {
        return String.format("Model.Ork{name='%s', tribe='%s', weapon='%s', armor='%s', banner='%s', strength=%d, agility=%d, intelligence=%d, health=%d}",
                name, tribe, weapon, armor, banner, strength, agility, intelligence, health);
    }
}
