package de.sparkofyt.troll.modules.subModules;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.utils.Var;

public class Module_Invsee implements CommandExecutor {
	private Main main;
	
	public Module_Invsee(Main main) {
		this.setMain(main);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[1]);
			
			if(player.isOp() || player.hasPermission("troll.use.invsee")) {
				if(target != null) {
					player.openInventory((Inventory)target.getInventory()); 
					player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 25);
				} else
					player.sendMessage(Var.OFFLINE);
			} else
				player.sendMessage(Var.NOPERM);
		}
		return false;
	}


	public Main getMain() {
		return main;
	}


	public void setMain(Main main) {
		this.main = main;
	}
}
