package tk.sirorabi.tutorial.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class TutorialEvents implements Listener{
    @EventHandler
    public void onFurnaceSmeltEvent(FurnaceSmeltEvent e){
        Bukkit.broadcastMessage("fired furnace smelt!");
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        new TutorialScheduler().runTaskTimer(Tutorial.getPlugin(), 0L, 20L);
    }
}
