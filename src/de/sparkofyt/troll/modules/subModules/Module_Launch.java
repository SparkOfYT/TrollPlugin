package de.sparkofyt.troll.modules.subModules;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.utils.Var;

public class Module_Launch implements CommandExecutor {
	private Main main;

	public Module_Launch(Main main) {
		this.setMain(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[1]);

			if (player.isOp() || player.hasPermission("troll.use.launch")) {
					if (target == player) {
						player.setVelocity(target.getLocation().getDirection().multiply(0.5).setY(3.8));
						player.playSound(target.getLocation(), Sound.ENTITY_PLAYER_BURP, 25, 100);
						player.sendMessage(Var.PREFIX + "§e§lWHOAHHHH!!!!!");
					}

					if (target != null) {
						if (target != player) {
							target.setVelocity(target.getLocation().getDirection().multiply(0.5).setY(3.8));
							target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_BURP, 25, 100);
							player.sendMessage(Var.PREFIX + "§6§l" + target.getName() + " §cfliegt nun!");
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
