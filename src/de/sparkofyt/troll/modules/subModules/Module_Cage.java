package de.sparkofyt.troll.modules.subModules;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.utils.Var;

public class Module_Cage implements CommandExecutor {
	private Main main;

	public Module_Cage(Main main) {
		this.setMain(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[1]);

			if (sender.isOp() || sender.hasPermission("troll.use.cage")) {
				if (target != null) {
					if (args.length >= 2) {
						if (args[2].equalsIgnoreCase("barrier")) {
							target.getWorld().getBlockAt(target.getLocation().add(0, -1, 0)).setType(Material.BARRIER);
							target.getWorld().getBlockAt(target.getLocation().add(0, 2, 0)).setType(Material.BARRIER);
							target.getWorld().getBlockAt(target.getLocation().add(1, 0, 0)).setType(Material.BARRIER);
							target.getWorld().getBlockAt(target.getLocation().add(-1, 0, 0)).setType(Material.BARRIER);
							target.getWorld().getBlockAt(target.getLocation().add(0, 0, 1)).setType(Material.BARRIER);
							target.getWorld().getBlockAt(target.getLocation().add(0, 0, -1)).setType(Material.BARRIER);
							player.sendMessage(
									Var.PREFIX + "§6§l" + target.getName() + " §aist nun im Barrier Gefängnis!");
						} else if (args[2].equalsIgnoreCase("bedrock")) {
							target.getWorld().getBlockAt(target.getLocation().add(0, -1, 0)).setType(Material.BEDROCK);
							target.getWorld().getBlockAt(target.getLocation().add(0, 2, 0)).setType(Material.BEDROCK);
							target.getWorld().getBlockAt(target.getLocation().add(1, 0, 0)).setType(Material.BEDROCK);
							target.getWorld().getBlockAt(target.getLocation().add(-1, 0, 0)).setType(Material.BEDROCK);
							target.getWorld().getBlockAt(target.getLocation().add(0, 0, 1)).setType(Material.BEDROCK);
							target.getWorld().getBlockAt(target.getLocation().add(0, 0, -1)).setType(Material.BEDROCK);
							player.sendMessage(
									Var.PREFIX + "§6§l" + target.getName() + " §aist nun im Bedrock Gefängnis!");
						} else if (args[2].equalsIgnoreCase("free")) {
							target.getWorld().getBlockAt(target.getLocation().add(0, -1, 0))
									.setType(Material.GRASS_BLOCK);
							target.getWorld().getBlockAt(target.getLocation().add(0, 2, 0)).setType(Material.AIR);
							target.getWorld().getBlockAt(target.getLocation().add(1, 0, 0)).setType(Material.AIR);
							target.getWorld().getBlockAt(target.getLocation().add(-1, 0, 0)).setType(Material.AIR);
							target.getWorld().getBlockAt(target.getLocation().add(0, 0, 1)).setType(Material.AIR);
							target.getWorld().getBlockAt(target.getLocation().add(0, 0, -1)).setType(Material.AIR);
							player.sendMessage(
									Var.PREFIX + "§6§l" + target.getName() + " §aist nun nicht mehr im Gefängnis!");
						}
					} else
						player.sendMessage(Var.sendHelpMessage(player));
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
