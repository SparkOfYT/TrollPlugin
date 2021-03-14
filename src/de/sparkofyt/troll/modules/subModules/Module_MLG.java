package de.sparkofyt.troll.modules.subModules;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.utils.Var;

public class Module_MLG implements CommandExecutor {
	private Main main;
	
	public Module_MLG(Main main) {
		this.setMain(main);
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			Player target = Bukkit.getPlayer(args[1]);
			
			ItemStack water = new ItemStack(Material.WATER_BUCKET);
			ItemStack web = new ItemStack(Material.COBWEB);
			ItemStack boat = new ItemStack(Material.OAK_BOAT);
			
			if(player.isOp() || player.hasPermission("troll.use.mlg")) {
			if(target != null) {
					if(args[2].equalsIgnoreCase("water")) {
						player.sendMessage(Var.PREFIX + "§6§l" + target.getName() + " §ader Spieler macht nun ein Water MLG!");
						target.getInventory().setItem(0, water);
						target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_BURP, 100, 25);
						target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 25);
						target.sendTitle("§e§lMACH EIN MLG", " ");
						target.setVelocity(target.getLocation().getDirection().multiply(0.5).setY(3.8));
					} else if(args[2].equalsIgnoreCase("web")) {
						player.sendMessage(Var.PREFIX + "§6§l" + target.getName() + " §ader Spieler macht nun ein Web MLG!");
						target.getInventory().setItem(0, web);
						target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_BURP, 100, 25);
						target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 25);
						target.sendTitle("§e§lMACH EIN MLG", " ");
						target.setVelocity(target.getLocation().getDirection().multiply(0.5).setY(3.8));
					} else if(args[2].equalsIgnoreCase("boat")) {
						player.sendMessage(Var.PREFIX + "§6§l" + target.getName() + " §ader Spieler macht nun ein Boat MLG!");
						target.getInventory().setItem(0, boat);
						target.playSound(target.getLocation(), Sound.ENTITY_PLAYER_BURP, 100, 25);
						target.playSound(target.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 100, 25);
						target.sendTitle("§e§lMACH EIN MLG", " ");
						target.setVelocity(target.getLocation().getDirection().multiply(0.5).setY(3.8));
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
