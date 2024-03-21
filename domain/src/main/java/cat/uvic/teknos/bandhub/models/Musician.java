package cat.uvic.teknos.bandhub.models;

import java.util.Set;

public interface Musician {
    int getId();
    void setId(int id);
    Genre getGenre();
    void setGenre(Genre genre);
    Set<Instrument> getInstruments();
    void setInstruments(Set<Instrument> instruments);
}
