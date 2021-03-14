package de.sparkofyt.troll.modules.subModules;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.utils.Var;

public class Module_TpAll implements CommandExecutor {
	private Main main;

	public Module_TpAll(Main main) {
		this.setMain(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			if (player.isOp() || player.hasPermission("troll.use.tpall")) {
				if (Bukkit.getServer().getOnlinePlayers().size() > 1) {
					for (Player allPlayers : Bukkit.getServer().getOnlinePlayers()) {
						allPlayers.teleport(player.getLocation());
					}
					player.sendMessage(Var.PREFIX + "§aEs wurden alle Spieler zu dir teleportiert!");
				} else
					player.sendMessage(Var.PREFIX + "§cEs ist niemand Online! :c");
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
