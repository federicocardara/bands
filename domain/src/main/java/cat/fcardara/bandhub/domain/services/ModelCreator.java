package cat.fcardara.bandhub.domain.services;

import cat.fcardara.bandhub.domain.models.Musician;

public interface ModelCreator {
    Musician getNewMusician();
}
