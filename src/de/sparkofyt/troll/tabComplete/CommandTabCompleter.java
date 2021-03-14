package de.sparkofyt.troll.tabComplete;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTabCompleter implements org.bukkit.command.TabCompleter {
  public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
    if (sender instanceof Player) {
      Player player = (Player)sender;
      if (player.isOp() || player.hasPermission("troll.use")) {
          List<String> list = new ArrayList<>();
          list.add("gamemode");
          list.add("tpall");
          list.add("help");
          list.add("freeze");
          list.add("launch");
          list.add("explosion");
          list.add("nyan");
          list.add("burn");
          list.add("strike");
          list.add("randomtp");
          list.add("mlg");
          list.add("creeper");
          list.add("cage");
          list.add("exit");
          list.add("invsee");
          if (args.length == 1) {
            List<String> finalList = new ArrayList<>();
            for (String add : list) {
              if (add.toLowerCase().startsWith(args[0].toLowerCase()))
                finalList.add(add); 
            } 
            return finalList;
          } 
        }  
    } 
    return null;
  }
}
