package cat.fcardara.bandhub.domain.models;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class MusiciansTest {
    @Test
    void testGetNew() {
        assertNotNull(Musicians.getNew());
    }
}
