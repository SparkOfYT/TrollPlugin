package de.sparkofyt.troll.modules.subModules;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.utils.Var;

public class Module_Creeper implements CommandExecutor {
	private Main main;

	public Module_Creeper(Main main) {
		this.setMain(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[1]);
			
			if(player.isOp() || player.hasPermission("troll.use.creeper")) {
				if(target != null) {
					player.sendMessage(Var.PREFIX + "§aBei " + "§6§l" + target.getName() + " §awurden Creeper gespawned!");
					target.getWorld().spawnEntity(target.getLocation().add(2, 0, 0), EntityType.CREEPER);
					target.getWorld().spawnEntity(target.getLocation().add(2, 0, 0), EntityType.CREEPER);
					target.getWorld().spawnEntity(target.getLocation().add(-2, 0, 0), EntityType.CREEPER);
					target.getWorld().spawnEntity(target.getLocation().add(-2, 0, 0), EntityType.CREEPER);
					target.getWorld().spawnEntity(target.getLocation().add(0, 0, 2), EntityType.CREEPER);
					target.getWorld().spawnEntity(target.getLocation().add(0, 0, 2), EntityType.CREEPER);
					target.getWorld().spawnEntity(target.getLocation().add(0, 0, -2), EntityType.CREEPER);
					target.getWorld().spawnEntity(target.getLocation().add(0, 0, -2), EntityType.CREEPER);
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
