package cat.uvic.teknos.bandhub.file.repositories;

import cat.uvic.teknos.bandhub.models.Musician;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MusicianRepository  implements cat.uvic.teknos.bandhub.repositories.MusicianRepository {
    private Map<Integer, Musician> musicians = new HashMap<>();
    private final String dataPath;

    public MusicianRepository(String dataPath) {
        this.dataPath = dataPath;

        load();
    }

    void load() {
        //var dataDirectory = System.getProperty("user.dir") + "/src/main/resources/data/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(dataPath))) {
           musicians = (Map<Integer, Musician>) inputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    void write() {
        try(var outputStream = new ObjectOutputStream(new FileOutputStream(dataPath))) {
            outputStream.writeObject(musicians);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Musician model) {
        if (model.getId() <= 0) {
            // get new id
            var newId = musicians.keySet().stream().mapToInt(k -> k).max().orElse(0) + 1;
            model.setId(newId);

            musicians.put(newId, model);
        } else {
            if (musicians.get(model.getId()) == null) {
                throw new RuntimeException("Musician with id " + model.getId() + " not found");
            }
            musicians.put(model.getId(), model);
        }

        write();
    }

    @Override
    public void delete(Musician model) {
        musicians.remove(model.getId());
    }

    @Override
    public Musician get(Integer id) {

        return musicians.get(id);
    }

    @Override
    public Set<Musician> getAll() {
        return Set.copyOf(musicians.values());
    }

    @Override
    public Musician getByName(String name) {
        return null;
    }
}
