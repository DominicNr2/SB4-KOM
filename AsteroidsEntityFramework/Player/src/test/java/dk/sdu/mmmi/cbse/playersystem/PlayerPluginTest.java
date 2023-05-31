package dk.sdu.mmmi.cbse.playersystem;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerPluginTest {
    private PlayerPlugin playerPlugin;
    private GameData gameData;
    private World world;

    @BeforeEach
    void setUp() {
        playerPlugin = new PlayerPlugin();
        gameData = new GameData();
        world = new World();
        playerPlugin.start(gameData, world);
    }
    @Test
    void isDead() {
        // Assert that the player entity is initially present in the world
        world.addEntity(playerPlugin.getPlayer());
        assertFalse(world.getEntities().isEmpty());

        // Call the stop method
        playerPlugin.stop(gameData, world);

        // Assert that the player entity is no longer present in the world
        assertTrue(world.getEntities().isEmpty());
    }
}