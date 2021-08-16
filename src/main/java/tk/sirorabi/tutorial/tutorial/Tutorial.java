package tk.sirorabi.tutorial.tutorial;

import org.bukkit.plugin.java.JavaPlugin;

public final class Tutorial extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("プラグイン起動！");
        getCommand("test").setExecutor(new TutorialCommands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグイン終了！");
    }
}
