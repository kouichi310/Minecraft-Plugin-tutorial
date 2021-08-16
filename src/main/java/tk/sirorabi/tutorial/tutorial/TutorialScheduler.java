package tk.sirorabi.tutorial.tutorial;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class TutorialScheduler extends BukkitRunnable{
    private int nowTime;

    public TutorialScheduler(){
        this.nowTime = 10;
    }

    @Override
    public void run() {
        if(nowTime < 0){
            Bukkit.broadcastMessage("どーーーん！");
            cancel();
            return;
        }
        Bukkit.broadcastMessage("残り" + nowTime + "秒");
        nowTime--;
    }
}
