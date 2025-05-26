package BuilderFactory;
import Model.Ork;
import Builder.OrkBuilder;

public class OrcDirector {
    private final OrkBuilderFactory builderFactory;

    public OrcDirector(OrkBuilderFactory builderFactory) {
        this.builderFactory = builderFactory;
    }

    public Ork createBasicOrk() {
        OrkBuilder builder = builderFactory.createOrkBuilder()
                .setName()
                .generateAttributes();
        return builder.build();
    }

    public Ork createLeaderOrk() {
        OrkBuilder builder = builderFactory.createOrkBuilder()
                .setName()
                .generateAttributes();

        builder.banner = builder.banner + " + Горн";
        return builder.build();
    }

    public Ork createScoutOrk() {
        OrkBuilder builder = builderFactory.createOrkBuilder()
                .setName()
                .generateAttributes();

        builder.weapon = "Лук";
        return builder.build();
    }
}
