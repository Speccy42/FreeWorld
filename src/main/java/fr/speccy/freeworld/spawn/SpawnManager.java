package fr.speccy.freeworld.spawn;

import fr.speccy.freeworld.FreeWorld;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.File;
import java.io.IOException;

public class SpawnManager {
    private static final File WORLD_FOLDER = new File("plugins/" + FreeWorld.main.getName() + "/maps/", "Spawn");

    public static void initialize() {
        if (!WORLD_FOLDER.exists()) return;
        String worldName = Bukkit.getWorlds().get(0).getName();

        World world = Bukkit.getWorld(worldName);
        if (world != null) {
            Bukkit.getServer().unloadWorld(world, false);
        }

        File worldContainer = new File(Bukkit.getWorldContainer(), worldName);
        Bukkit.getScheduler().runTask(FreeWorld.main, () -> {
            try {
                if (worldContainer.exists()) {
                    FileUtils.deleteDirectory(worldContainer);
                }
                FileUtils.copyDirectory(WORLD_FOLDER, worldContainer);

                World newWorld = Bukkit.createWorld(new WorldCreator(worldName));
                newWorld.setAutoSave(false);
                newWorld.setStorm(false);
                newWorld.setThundering(false);
                newWorld.setPVP(false);
                newWorld.setTime(6000L);
                newWorld.setDifficulty(Difficulty.NORMAL);
                newWorld.setSpawnLocation(0, 65, 0);
                newWorld.setGameRuleValue("commandBlockOutput", "false");
                newWorld.setGameRuleValue("disableElytraMovementCheck", "false");
                newWorld.setGameRuleValue("doDaylightCycle", "false");
                newWorld.setGameRuleValue("doEntityDrops", "false");
                newWorld.setGameRuleValue("doFireTick", "false");
                newWorld.setGameRuleValue("doMobLoot", "false");
                newWorld.setGameRuleValue("doMobSpawning", "false");
                newWorld.setGameRuleValue("doTileDrops", "false");
                newWorld.setGameRuleValue("keepInventory", "false");
                newWorld.setGameRuleValue("logAdminCommands", "true");
                newWorld.setGameRuleValue("mobGriefing", "false");
                newWorld.setGameRuleValue("naturalRegeneration", "true");
                newWorld.setGameRuleValue("randomTickSpeed", "0");
                newWorld.setGameRuleValue("reducedDebugInfo", "true");
                newWorld.setGameRuleValue("sendCommandFeedback", "true");
                newWorld.setGameRuleValue("showDeathMessages", "false");
                newWorld.setGameRuleValue("spawnRadius", "1");
                newWorld.setGameRuleValue("spectatorsGenerateChunks", "true");

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
