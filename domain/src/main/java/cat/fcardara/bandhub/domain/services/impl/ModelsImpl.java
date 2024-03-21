package cat.fcardara.bandhub.domain.services.impl;

import cat.fcardara.bandhub.domain.models.Musician;
import cat.fcardara.bandhub.domain.services.Models;

public class ModelsImpl implements Models{

    @Override
    public Musician newMusician() {
        return new cat.fcardara.bandhub.domain.models.impl.Musician();
    }

}
