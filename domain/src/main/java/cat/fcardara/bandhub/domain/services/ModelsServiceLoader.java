package cat.fcardara.bandhub.domain.services;

import java.util.ServiceLoader;

public class ModelsServiceLoader {
    public static final Models SERVICE;

    static{
        SERVICE = load();
    } 

    private static Models load() {
        var serviceLoader = ServiceLoader.load(Models.class);

        return serviceLoader.findFirst().orElseThrow();
    }
}
