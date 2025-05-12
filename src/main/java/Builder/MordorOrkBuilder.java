package Builder;

public class MordorOrkBuilder extends OrkBuilder {

    @Override
    public OrkBuilder generateAttributes() {
        strength = rand.nextInt(70) + 30; // +30%
        agility = rand.nextInt(50);              // низкая ловкость
        intelligence = rand.nextInt(50);
        health = rand.nextInt(150) + 50;
        return this;
    }

    @Override
    public OrkBuilder equip() {
        weapon = "Тяжелый меч";
        armor = "Стальная броня";
        banner = "Знамя с Красным Оком";
        return this;
    }

    @Override
    public String getTribe() {
        return "Мордор";
    }
}
