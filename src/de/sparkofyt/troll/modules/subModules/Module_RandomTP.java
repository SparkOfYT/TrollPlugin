package de.sparkofyt.troll.modules.subModules;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.utils.Methods;
import de.sparkofyt.troll.utils.Var;

public class Module_RandomTP implements CommandExecutor {
	private Main main;

	public Module_RandomTP(Main main) {
		this.setMain(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[1]);

			if (player.isOp() || player.hasPermission("troll.use.randomtp")) {
				if (target != null) {
					if (!Var.RANDOMTP.contains(target)) {
						Var.RANDOMTP.add(target);
						Methods.rmdTeleport();
						player.sendMessage(Var.PREFIX + "§6§l" + target.getName() + " §awird nun hin und her tped!");
					} else {
						Var.RANDOMTP.remove(target);
						player.sendMessage(
								Var.PREFIX + "§6§l" + target.getName() + " §cwird nun nicht mehr hin und her tped!");
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
