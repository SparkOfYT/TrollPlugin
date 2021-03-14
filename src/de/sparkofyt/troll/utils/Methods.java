package de.sparkofyt.troll.utils;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import de.sparkofyt.troll.Main;

public class Methods {
	static Plugin plugin = (Plugin)Main.getPlugin(Main.class);
	
	public static void rmdTeleport() {
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin , new Runnable() {
	          public void run() {
	            if (Var.RANDOMTP.isEmpty())
	              return; 
	            for (Player p : Bukkit.getServer().getOnlinePlayers()) {
	              if (Var.RANDOMTP.contains(p)) {
	                Random rmd = new Random();
	                int x = rmd.nextInt(11) - 5;
	                int y = rmd.nextInt(11) - 5;
	                int z = rmd.nextInt(11) - 5;
	                p.teleport(p.getLocation().add(x, y, z));
	              } 
	            } 
	          }
	        }, 0, 5);
	  }
}
