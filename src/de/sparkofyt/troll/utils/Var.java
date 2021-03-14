package de.sparkofyt.troll.utils;

import java.util.ArrayList;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Var {
	public static final String PREFIX = "§7[§5§lTrolls§7]: ";
	public static final String AUTHOR = "SparkOfYT";
	public static final String VERSION = "1.1";
	public static final String NOPERM = PREFIX + "§cBesorg dir erstmal Rechte!";
	public static final String NOCOMMAND = PREFIX + "§cDiesen Befehl gibt es nicht!";
	public static final String OFFLINE = PREFIX + "§cDieser Spieler ist zurzeit nicht Online!";
	public static final String HACKER = "<§kHacker§r> ";

	public static final ArrayList<Player> FREEZE = new ArrayList<>();
	public static final ArrayList<String> EXPLOSION = new ArrayList<>();
	public static final ArrayList<Player> NYAN = new ArrayList<>();
	public static final ArrayList<Player> BURN = new ArrayList<>();
	public static final ArrayList<Player> STRIKE = new ArrayList<>();
	public static final ArrayList<Player> RANDOMTP = new ArrayList<>();
	public static ArrayList<Player> SkyAttackVictims = new ArrayList<Player>();
	public static ArrayList<Entity> SkyAttackChicken = new ArrayList<Entity>();

	public static String sendHelpMessage(Player player) {
		player.sendMessage("§7§l----------⋙ §b§lTroll §7§l⋘----------");
		player.sendMessage("§7§l          ⋙ §bBy: " + AUTHOR + " §7§l⋘          ");
		player.sendMessage("§7§l          ⋙ §bVersion: " + VERSION + " §7§l⋘          ");
		player.sendMessage("§7§l----------⋙ §b§lCommands §7§l⋘----------");
		player.sendMessage("§f§l/troll help");
		player.sendMessage("§f§l/troll tpall");
		player.sendMessage("§f§l/troll gamemode [0, 1, 2, 3]");
		player.sendMessage("§f§l/troll freeze [Spieler]");
		player.sendMessage("§f§l/troll launch [Spieler]");
		player.sendMessage("§f§l/troll explosion [Spieler]");
		player.sendMessage("§f§l/troll nyan [Spieler]");
		player.sendMessage("§f§l/troll burn [Spieler]");
		player.sendMessage("§f§l/troll strike [Spieler]");
		player.sendMessage("§f§l/troll randomtp [Spieler]");
		player.sendMessage("§f§l/troll creeper [Spieler]");
		player.sendMessage("§f§l/troll mlg [Spieler] [water, web, boat]");
		player.sendMessage("§f§l/troll cage [Spieler] [bedrock, barrier, free]");
		player.sendMessage("§f§l/troll exit [Spieler");
		player.sendMessage("§7§l----------⋙ §b§lTroll §7§l⋘----------");
		return null;
	}
}
