package cat.uvic.teknos.bandhub.repositories;

import cat.uvic.teknos.bandhub.models.Musician;

import java.util.Set;

public interface MusicianRepository extends Repository<Integer, Musician> {
    @Override
    void save(Musician model);

    @Override
    void delete(Musician model);

    @Override
    Musician get(Integer id);

    @Override
    Set<Musician> getAll();

    Musician getByName(String name);
}
