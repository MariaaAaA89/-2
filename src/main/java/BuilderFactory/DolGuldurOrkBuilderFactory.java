package BuilderFactory;
import Factory.DolGuldurGearFactory;
import Factory.OrcGearFactory;
import Builder.DolGuldurOrkBuilder;
import Builder.OrkBuilder;

public class DolGuldurOrkBuilderFactory implements OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        OrkBuilder builder = new DolGuldurOrkBuilder();
        OrcGearFactory gearFactory = new DolGuldurGearFactory();
        builder.weapon = gearFactory.createWeapon();
        builder.armor = gearFactory.createArmor();
        builder.banner = gearFactory.createBanner();
        return builder;
    }
}
