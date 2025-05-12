package BuilderFactory;

import Builder.MordorOrkBuilder;
import Builder.OrkBuilder;
import Factory.MordorGearFactory;
import Factory.OrcGearFactory;

public class MordorOrkBuilderFactory implements OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        OrkBuilder builder = new MordorOrkBuilder();
        OrcGearFactory gearFactory = new MordorGearFactory();
        builder.weapon = gearFactory.createWeapon();
        builder.armor = gearFactory.createArmor();
        builder.banner = gearFactory.createBanner();
        return builder;
    }
}
