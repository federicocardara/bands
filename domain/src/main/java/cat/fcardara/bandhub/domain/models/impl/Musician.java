package cat.fcardara.bandhub.domain.models.impl;

public class Musician implements cat.fcardara.bandhub.domain.models.Musician{
    private int id;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

}
