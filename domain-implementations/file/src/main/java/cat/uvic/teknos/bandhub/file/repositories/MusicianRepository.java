package cat.uvic.teknos.bandhub.file.repositories;

import cat.uvic.teknos.bandhub.models.Musician;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class MusicianRepository  implements cat.uvic.teknos.bandhub.repositories.MusicianRepository {
    private static Map<Integer, Musician> musicians = new HashMap<>();

    static void load() {
        var dataDirectory = System.getProperty("user.dir") + "/src/main/resources/data/";

        try(var inputStream = new ObjectInputStream(new FileInputStream(dataDirectory + "musicians.ser"))) {
           musicians = (Map<Integer, Musician>) inputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static void write() {
        var dataDirectory = System.getProperty("user.dir") + "/src/main/resources/data/";

        try(var outputStream = new ObjectOutputStream(new FileOutputStream(dataDirectory + "musicians.ser"))) {
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
        return null;
    }

    @Override
    public Musician getByName(String name) {
        return null;
    }
}
