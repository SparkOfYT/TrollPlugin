package de.sparkofyt.troll.modules.subModules;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.utils.Var;

public class Module_Strike implements CommandExecutor {
	private Main main;

	public Module_Strike(Main main) {
		this.setMain(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[1]);

			if (player.isOp() || player.hasPermission("troll.use.strike")) {
				if (target != null) {
					if (!Var.STRIKE.contains(target)) {
						Var.STRIKE.add(target);
						player.sendMessage(Var.PREFIX + "§6§l" + target.getName() + " §awird nun vom Blitz verfolgt!");
					} else {
						Var.STRIKE.remove(target);
						player.sendMessage(
								Var.PREFIX + "§6§l" + target.getName() + " §cwird nun nicht mehr vom Blitz verfolgt!");
					}
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
