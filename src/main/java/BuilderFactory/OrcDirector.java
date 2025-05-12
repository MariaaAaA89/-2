package BuilderFactory;
import Model.Ork;
import Builder.OrkBuilder;

public class OrcDirector {
    private final OrkBuilderFactory builderFactory;

    public OrcDirector(OrkBuilderFactory builderFactory) {
        this.builderFactory = builderFactory;
    }

    public Ork createBasicOrk(String name) {
        OrkBuilder builder = builderFactory.createOrkBuilder()
                .setName(name)
                .generateAttributes();
        return builder.build();
    }

    public Ork createLeaderOrk(String name) {
        OrkBuilder builder = builderFactory.createOrkBuilder()
                .setName(name)
                .generateAttributes();

        builder.banner = builder.banner + " + Горн";
        return builder.build();
    }

    public Ork createScoutOrk(String name) {
        OrkBuilder builder = builderFactory.createOrkBuilder()
                .setName(name)
                .generateAttributes();

        builder.weapon = "Лук";
        return builder.build();
    }
}
