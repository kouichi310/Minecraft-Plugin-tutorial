package tk.sirorabi.tutorial.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Tutorial extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("プラグイン起動！");
        getCommand("test").setExecutor(new TutorialCommands());
        plugin = this;
        Bukkit.getServer().getPluginManager().registerEvents(new TutorialEvents(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグイン終了！");
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}

