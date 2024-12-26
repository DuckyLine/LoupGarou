package fr.line.loupGarous.World;

import org.bukkit.*;
import org.bukkit.entity.Player;

public class WorldManager
{

    public static World createEmptyWorld(String worldName) {
        // Configurer le générateur de monde
        WorldCreator creator = new WorldCreator(worldName);
        creator.environment(World.Environment.NORMAL);
        creator.generator(new EmptyWorldGenerator());

        // Créer le monde
        World world = creator.createWorld();

        if (world != null) {
            world.setPVP(false);
            world.setDifficulty(Difficulty.PEACEFUL);
        }

        return world;
    }

    public static void teleportPlayerToWorld(Player player, World world)
    {
        Location spawnLocation = world.getSpawnLocation();
        player.teleport(spawnLocation);
    }

}
