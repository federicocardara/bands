package cat.uvic.teknos.bandhub.repositories;

import cat.uvic.teknos.bandhub.models.Instrument;

import java.util.Set;

public interface InstrumentRepository  extends Repository<Integer, Instrument>{
    @Override
    void save(Instrument model);

    @Override
    void delete(Instrument model);

    @Override
    Instrument get(Integer id);

    @Override
    Set<Instrument> getAll();
}
