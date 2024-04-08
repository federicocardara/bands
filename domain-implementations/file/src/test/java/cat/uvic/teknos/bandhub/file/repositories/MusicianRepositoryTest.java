package cat.uvic.teknos.bandhub.file.repositories;

import cat.uvic.teknos.bandhub.file.models.Musician;
import cat.uvic.teknos.bandhub.models.Genre;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicianRepositoryTest {

    @Test
    void saveNewMusician() {
        var repository = new MusicianRepository();

        var male = new cat.uvic.teknos.bandhub.file.models.Genre();
        male.setId(1);
        male.setDescription("Male");
        var musician = new Musician();
        musician.setGenre(male);

        repository.save(musician);

        // check if id is greater than 0
        assertTrue(musician.getId() > 0);
        // check if the musician is properly added to the map
        assertNotNull(repository.get(musician.getId()));

        MusicianRepository.load();

        // check if the musician is properly added to the map
        assertNotNull(repository.get(musician.getId()));
        assertEquals("Male", repository.get(musician.getId()).getGenre().getDescription());


    }


    @Test
    void updateMusician() {

    }
}