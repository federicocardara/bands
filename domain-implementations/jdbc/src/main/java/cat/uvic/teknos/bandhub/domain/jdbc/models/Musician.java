package cat.uvic.teknos.bandhub.domain.jdbc.models;

import cat.uvic.teknos.bandhub.models.Genre;
import cat.uvic.teknos.bandhub.models.Instrument;

import java.io.Serializable;
import java.util.Set;

public class Musician implements cat.uvic.teknos.bandhub.models.Musician {
    private int id;
    private Genre genre;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Genre getGenre() {
        return genre;
    }

    @Override
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public Set<Instrument> getInstruments() {
        return null;
    }

    @Override
    public void setInstruments(Set<Instrument> instruments) {

    }
}
