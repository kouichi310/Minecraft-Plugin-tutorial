package tk.sirorabi.tutorial.tutorial;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TutorialCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(command.getName().equalsIgnoreCase("test")){ //親コマンド判定
            sender.sendMessage("§a/test が実行されました。");
            if(args.length == 0){ //サブコマンドの数が0,サブコマンド無し
                sender.sendMessage("§eサブコマンドなし！");
                return true; //終わり
            }else{ //サブコマンドあり
                sender.sendMessage("§eサブコマンドあり！");
                if (args[0].equalsIgnoreCase("hello")){ //サブコマンドが[hello]
                    sender.sendMessage("Hello world!");
                }else { //違う
                    sender.sendMessage("サブコマンドはhello以外である");
                }
                return true;//終わり
            }
        }
        return false;
    }
}
