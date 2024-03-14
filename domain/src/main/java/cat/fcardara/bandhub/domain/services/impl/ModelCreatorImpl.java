package cat.fcardara.bandhub.domain.services.impl;

import cat.fcardara.bandhub.domain.models.Musician;
import cat.fcardara.bandhub.domain.services.ModelCreator;

public class ModelCreatorImpl implements ModelCreator{

    @Override
    public Musician getNewMusician() {
        return new cat.fcardara.bandhub.domain.models.impl.Musician();
    }

}
