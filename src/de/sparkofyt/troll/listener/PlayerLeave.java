package de.sparkofyt.troll.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.sparkofyt.troll.utils.Var;

public class PlayerLeave implements Listener {
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		
		if(Var.EXPLOSION.contains(player.getName())) {
			Var.EXPLOSION.remove(player.getName());
		}
	}

}
