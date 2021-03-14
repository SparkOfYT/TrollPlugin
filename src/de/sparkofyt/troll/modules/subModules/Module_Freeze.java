package de.sparkofyt.troll.modules.subModules;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.utils.Var;

public class Module_Freeze implements CommandExecutor {
	private Main main;

	public Module_Freeze(Main main) {
		this.setMain(main);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[1]);

			if (player.isOp() || player.hasPermission("troll.use.freeze")) {
				if (target != null) {
					if (!Var.FREEZE.contains(target)) {
						Var.FREEZE.add(target);
						target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999999, 255));
						player.sendMessage(Var.PREFIX + "§6§l" + target.getName() + " §aist nun freeze!");
					} else if (Var.FREEZE.contains(target)) {
						Var.FREEZE.remove(target);
						target.removePotionEffect(PotionEffectType.SLOW);
						player.sendMessage(Var.PREFIX + "§6§l" + target.getName() + " §cist nun nicht freeze!");
					} else
						player.sendMessage(Var.OFFLINE);
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
