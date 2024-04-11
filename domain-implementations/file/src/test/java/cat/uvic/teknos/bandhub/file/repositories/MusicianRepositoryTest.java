package cat.uvic.teknos.bandhub.file.repositories;

import cat.uvic.teknos.bandhub.file.models.Musician;
import cat.uvic.teknos.bandhub.models.Genre;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

class MusicianRepositoryTest {

    @Test
    void saveNewMusician() {
        var dataPath = System.getProperty("user.dir") + "/src/main/resources/data/musicians.ser";
        var repository = new MusicianRepository(dataPath);

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

        repository.load();

        // check if the musician is properly added to the map
        assertNotNull(repository.get(musician.getId()));
        assertEquals("Male", repository.get(musician.getId()).getGenre().getDescription());

    }


    @Test
    void updateMusician() throws IOException {
        var dataPath = System.getProperty("user.dir") + "/src/test/resources/data/update-musicians.ser";
        var testDataPath = System.getProperty("user.dir") + "/src/test/resources/data/test-update-musicians.ser";

        Files.copy(Path.of(dataPath), Path.of(testDataPath), StandardCopyOption.REPLACE_EXISTING);

        var repository = new MusicianRepository(testDataPath);

        var musician = new Musician();
        musician.setId(1);
        var  male = new cat.uvic.teknos.bandhub.file.models.Genre();
        male.setId(2);
        male.setDescription("Male");

        musician.setGenre(male);

        repository.save(musician);

        var updatedMusician = repository.get(1);
        assertEquals(2, updatedMusician.getGenre().getId());

        repository.load();
        var updatedMusicianFromFile = repository.get(1);
        assertEquals(2, updatedMusicianFromFile.getGenre().getId());



    }

    @Test
    void updateMusicianThatDoestExist() throws IOException {
        var dataPath = System.getProperty("user.dir") + "/src/test/resources/data/update-musicians.ser";
        var testDataPath = System.getProperty("user.dir") + "/src/test/resources/data/test-update-musicians.ser";
        int id = 3;

        Files.copy(Path.of(dataPath), Path.of(testDataPath), StandardCopyOption.REPLACE_EXISTING);

        var repository = new MusicianRepository(testDataPath);

        var musician = new Musician();

        musician.setId(id);
        var  male = new cat.uvic.teknos.bandhub.file.models.Genre();
        male.setId(2);
        male.setDescription("Male");

        musician.setGenre(male);

        assertThrows(RuntimeException.class, () -> repository.save(musician));
    }
}