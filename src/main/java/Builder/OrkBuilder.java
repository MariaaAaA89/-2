package Builder;

import Model.Ork;
import com.github.javafaker.Faker;
import java.util.Random;

public abstract class OrkBuilder {
    protected String name;
    public String weapon;
    public String armor;
    public String banner;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int health;
    protected Faker faker = new Faker();
    protected Random rand = new Random();

    public OrkBuilder setName(String name) {
        this.name = name != null ? name : faker.lordOfTheRings().character();
        return this;
    }

    public abstract OrkBuilder generateAttributes();
    public abstract OrkBuilder equip();

    public Ork build() {
        return new Ork(name, weapon, armor, banner, strength, agility, intelligence, health, getTribe());
    }

    public abstract String getTribe();
}
