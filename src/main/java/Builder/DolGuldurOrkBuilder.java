package Builder;

public class DolGuldurOrkBuilder extends OrkBuilder {

    @Override
    public OrkBuilder generateAttributes() {
        strength = rand.nextInt(100);
        agility = rand.nextInt(100);
        intelligence = rand.nextInt(50);
        health = rand.nextInt(150) + 50;
        return this;
    }

    @Override
    public OrkBuilder equip() {
        weapon = "Копье";
        armor = "Кольчуга";
        banner = "Знамя с пауком";
        return this;
    }

    @Override
    public String getTribe() {
        return "Дол Гулдур";
    }
}
