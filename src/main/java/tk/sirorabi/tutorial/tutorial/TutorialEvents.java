package tk.sirorabi.tutorial.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.FurnaceStartSmeltEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;

public class TutorialEvents implements Listener{
    int[] lc = new int[3];
    String name,source,result;
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent e) {
        name = e.getPlayer().getName();
        if(e.getInventory().getType() == InventoryType.FURNACE) {
            lc[0] = e.getPlayer().getLocation().getBlockX();
            lc[1] = e.getPlayer().getLocation().getBlockY();
            lc[2] = e.getPlayer().getLocation().getBlockZ();
        }
    }
    @EventHandler
    public void onFurnaceStartSmeltEvent(FurnaceStartSmeltEvent e){
        source = e.getSource().getType().getKey().getKey();
        result = e.getRecipe().getKey().getKey();
    }
    @EventHandler
    public void onFurnaceSmeltEvent(FurnaceSmeltEvent e){
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tellraw "+ name +" [\"\",{\"text\":\""+ name +"\",\"color\":\"yellow\"},{\"text\":\"\\u3055\\u3093\\n\\u3042\\u306a\\u305f\\u304c\\u713c\\u3044\\u305f\"},{\"text\":\""+ source +"\",\"color\":\"aqua\"},{\"text\":\"\\u304c\"},{\"text\":\""+ result +"\",\"color\":\"red\"},{\"text\":\"\\u306b\\u306a\\u308a\\u307e\\u3057\\u305f\\u3088\\u3002\\n\"},{\"text\":\""+ lc[0]+","+lc[1]+","+lc[2] +"\",\"underlined\":true,\"color\":\"green\",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"/tp "+ name +" "+lc[0]+" "+lc[1]+" "+lc[2]+"\"}},{\"text\":\"\\u307e\\u3067\\u53d7\\u3051\\u53d6\\u308a\\u306b\\u6765\\u3066\\u304f\\u3060\\u3055\\u3044\\u3002\"}]");
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        new TutorialScheduler().runTaskTimer(Tutorial.getPlugin(), 0L, 20L);
    }
}
