package cat.uvic.teknos.bandhub.repositories;

import cat.uvic.teknos.bandhub.models.Musician;

import java.util.Set;

public interface MusicianRepository extends Repository<Integer, Musician> {
    Musician getByName(String name);
}
