package Builder;

public class MistyMountainsOrkBuilder extends OrkBuilder {

    @Override
    public OrkBuilder generateAttributes() {
        strength = rand.nextInt(100);
        agility = rand.nextInt(70) + 30; // +30% ловкость
        intelligence = rand.nextInt(20);        // низкий интеллект
        health = rand.nextInt(150) + 50;
        return this;
    }

    @Override
    public OrkBuilder equip() {
        weapon = "Топор";
        armor = "Кожаная броня";
        banner = "Знамя с Луной";
        return this;
    }

    @Override
    public String getTribe() {
        return "Мглистые Горы";
    }
}
