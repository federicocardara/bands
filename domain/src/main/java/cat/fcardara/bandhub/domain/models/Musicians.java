package cat.fcardara.bandhub.domain.models;

import cat.fcardara.bandhub.domain.services.ModelCreatorServiceLoader;

public interface Musicians {
    static Musician getNew() {
        return ModelCreatorServiceLoader.SERVICE.getNewMusician();
    }
}
