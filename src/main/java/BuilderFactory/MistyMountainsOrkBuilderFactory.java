package BuilderFactory;

import Builder.MistyMountainsOrkBuilder;
import Builder.OrkBuilder;
import Factory.MistyMountainsGearFactory;
import Factory.OrcGearFactory;

public class MistyMountainsOrkBuilderFactory implements OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        OrkBuilder builder = new MistyMountainsOrkBuilder();
        OrcGearFactory gearFactory = new MistyMountainsGearFactory();
        builder.weapon = gearFactory.createWeapon();
        builder.armor = gearFactory.createArmor();
        builder.banner = gearFactory.createBanner();
        return builder;
    }
}
