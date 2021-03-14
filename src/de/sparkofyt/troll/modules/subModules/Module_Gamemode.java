package de.sparkofyt.troll.modules.subModules;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.utils.Var;

public class Module_Gamemode implements CommandExecutor {
	private Main main;

	public Module_Gamemode(Main main) {
		this.setMain(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;

			if (player.isOp() || player.hasPermission("troll.use.gamemode")) {
				if (args.length == 2 || args.length > 2) {
					if (args[1].equalsIgnoreCase("0")) {
						if (!player.getGameMode().equals(GameMode.SURVIVAL)) {
							player.setGameMode(GameMode.SURVIVAL);
							player.sendMessage(Var.PREFIX + "§aDu bist nun im Gamemode 0!");
						} else {
							player.sendMessage(Var.PREFIX + "§cDu bist bereits im Gamemode 0!");
						}
					} else if (args[1].equalsIgnoreCase("1")) {
						if (!player.getGameMode().equals(GameMode.CREATIVE)) {
							player.setGameMode(GameMode.CREATIVE);
							player.sendMessage(Var.PREFIX + "§aDu bist nun im Gamemode 1!");
						} else {
							player.sendMessage(Var.PREFIX + "§cDu bist bereits im Gamemode 1!");
						}
					} else if (args[1].equalsIgnoreCase("2")) {
						if (!player.getGameMode().equals(GameMode.ADVENTURE)) {
							player.setGameMode(GameMode.ADVENTURE);
							player.sendMessage(Var.PREFIX + "§aDu bist nun im Gamemode 2!");
						} else {
							player.sendMessage(Var.PREFIX + "§cDu bist bereits im Gamemode 2!");
						}
					} else if (args[1].equalsIgnoreCase("3")) {
						if (!player.getGameMode().equals(GameMode.SPECTATOR)) {
							player.setGameMode(GameMode.SPECTATOR);
							player.sendMessage(Var.PREFIX + "§aDu bist nun im Gamemode 3!");
						} else {
							player.sendMessage(Var.PREFIX + "§cDu bist bereits im Gamemode 3!");
						}
					}
				}
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
