package cat.uvic.teknos.bandhub.file.models;

import java.io.Serializable;

public class Genre implements cat.uvic.teknos.bandhub.models.Genre, Serializable {
    private int id;
    private String description;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
