package de.sparkofyt.troll;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.sparkofyt.troll.listener.PlayerLeave;
import de.sparkofyt.troll.modules.Module_Troll;
import de.sparkofyt.troll.tabComplete.CommandTabCompleter;
import de.sparkofyt.troll.utils.Var;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();
		this.getCommand("troll").setExecutor(new Module_Troll(this));
		this.getCommand("troll").setTabCompleter((TabCompleter)new CommandTabCompleter());
		pm.registerEvents(new PlayerLeave(), this);
		runnable();

		super.onEnable();
	}

	private void runnable() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				for (int i = 0; i < Var.EXPLOSION.size(); i++) {
					String target = Var.EXPLOSION.get(i);
					if (Var.EXPLOSION.contains(target)) {
						if (Bukkit.getPlayer(target) != null) {
							Bukkit.getPlayer(target).getWorld().createExplosion(Bukkit.getPlayer(target).getLocation(),
									32);
						}
					}
				}

				Material material = null;
				Random random = new Random();
				while (material == null) {
					material = Material.values()[random.nextInt(Material.values().length)];
					if (!(material.isBlock())) {
						material = null;
					}
				}

				for (int i = 0; i < Var.NYAN.size(); i++) {
					Player target = Var.NYAN.get(i);
					Material mat = material;
					if (Var.NYAN.contains(target)) {
						target.getWorld().spawnFallingBlock(target.getLocation().add(0, 1, 0), mat, (byte) 0);
					}
				}

				for (int i = 0; i < Var.BURN.size(); i++) {
					Player target = Var.BURN.get(i);
					if (Var.BURN.contains(target)) {
						target.setFireTicks(1);
					}
				}

				for (int i = 0; i < Var.STRIKE.size(); i++) {
					Player target = Var.STRIKE.get(i);
					if (Var.STRIKE.contains(target)) {
						target.getWorld().strikeLightning(target.getLocation());
					}
				}
			}
		}, 0, 20 * 2);
	}
}
