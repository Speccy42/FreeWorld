package fr.speccy.freeworld;

import com.grinderwolf.swm.api.SlimePlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class FreeWorld extends JavaPlugin {
    public static FreeWorld main;
    public static SlimePlugin slimePlugin;

    @Override
    public void onEnable() {
        main = this;
        slimePlugin = (SlimePlugin) Bukkit.getPluginManager().getPlugin("SlimeWorldManager");
    }

    @Override
    public void onDisable() {

    }
}
