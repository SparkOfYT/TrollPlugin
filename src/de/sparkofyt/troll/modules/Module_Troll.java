package de.sparkofyt.troll.modules;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.sparkofyt.troll.Main;
import de.sparkofyt.troll.modules.subModules.*;
import de.sparkofyt.troll.utils.Var;

public class Module_Troll implements CommandExecutor {
	private Main main;
	private Module_Gamemode subGamemode;
	private Module_TpAll subTpAll;
	private Module_Help subHelp;
	private Module_Freeze subFreeze;
	private Module_Launch subLaunch;
	private Module_Explosion subExplosion;
	private Module_Nyan subNyan;
	private Module_Strike subStrike;
	private Module_Burn subBurn;
	private Module_RandomTP subRandomTP;
	private Module_MLG subMLG;
	private Module_Creeper subCreeper;
	private Module_Cage subCage;
	private Module_Exit subExit;
	private Module_Invsee subInvsee;

	public Module_Troll(Main main) {
		this.main = main;
		this.subGamemode = new Module_Gamemode(this.main);
		this.subTpAll = new Module_TpAll(this.main);
		this.subHelp = new Module_Help(this.main);
		this.subFreeze = new Module_Freeze(this.main);
		this.subLaunch = new Module_Launch(this.main);
		this.subExplosion = new Module_Explosion(this.main);
		this.subNyan = new Module_Nyan(this.main);
		this.subStrike = new Module_Strike(this.main);
		this.subBurn = new Module_Burn(this.main);
		this.subRandomTP = new Module_RandomTP(this.main);
		this.subMLG = new Module_MLG(this.main);
		this.subCreeper = new Module_Creeper(this.main);
		this.subCage = new Module_Cage(this.main); 
		this.subExit = new Module_Exit(this.main);
	    this.subInvsee = new Module_Invsee(this.main);	
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (player.isOp() || player.hasPermission("troll.use")) {
				if (args.length >= 1) {
					switch (args[0].toLowerCase()) {
					case "gamemode":
						this.subGamemode.onCommand(player, cmd, label, args);
						break;
					case "tpall":
						this.subTpAll.onCommand(player, cmd, label, args);
						break;
					case "help":
						this.subHelp.onCommand(player, cmd, label, args);
						break;
					case "freeze":
						this.subFreeze.onCommand(player, cmd, label, args);
						break;
					case "launch":
						this.subLaunch.onCommand(player, cmd, label, args);
						break;
					case "explosion":
						this.subExplosion.onCommand(player, cmd, label, args);
						break;
					case "nyan":
						this.subNyan.onCommand(player, cmd, label, args);
						break;
					case "burn":
						this.subBurn.onCommand(player, cmd, label, args);
						break;
					case "strike":
						this.subStrike.onCommand(player, cmd, label, args);
						break;
					case "randomtp":
						this.subRandomTP.onCommand(player, cmd, label, args);
						break;
					case "mlg":
						this.subMLG.onCommand(player, cmd, label, args);
						break;
					case "creeper":
					    this.subCreeper.onCommand(player, cmd, label, args);
					    break;
					case "cage":
						this.subCage.onCommand(player, cmd, label, args);
						break;
					case "exit":
						this.subExit.onCommand(player, cmd, label, args);
						break;
					case "invsee":
						this.subInvsee.onCommand(player, cmd, label, args);
						break;
					default:
						player.sendMessage(Var.sendHelpMessage(player));
					}

				} else
					player.sendMessage(Var.sendHelpMessage(player));
			}
		}
		return false;
	}
}
