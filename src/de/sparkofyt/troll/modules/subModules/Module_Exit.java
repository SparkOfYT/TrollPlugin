package de.sparkofyt.troll.modules.subModules;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.utils.Var;

public class Module_Exit implements CommandExecutor {
	private Main main;
	
	public Module_Exit(Main main) {
		this.setMain(main);
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[1]);
			
			if(player.isOp() || player.hasPermission("troll.use.exit")) {
				if(target != null) {
					if(target.isInsideVehicle()) {
						target.leaveVehicle();
						player.sendMessage(Var.PREFIX + "§6§l" + target.getName() + " §aist nun ausgestiegen!");
					} else
						player.sendMessage(Var.PREFIX + "§6§l" + target.getName() + " §cbefindet sich nicht in einem Fahrzeug!");
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
