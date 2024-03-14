package cat.fcardara.bandhub.domain.services;

import java.util.ServiceLoader;

public class ModelCreatorServiceLoader {
    public static final ModelCreator SERVICE;

    static {
        SERVICE = load();
    }

    private static ModelCreator load() {
        var serviceLoader = ServiceLoader.load(ModelCreator.class);

        return serviceLoader.findFirst().orElseThrow();
    }
}
