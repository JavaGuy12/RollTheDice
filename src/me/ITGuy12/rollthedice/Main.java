package me.ITGuy12.rollthedice;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.ChatColor;
public class Main extends JavaPlugin {
	
	Permission dice = new Permission("rtd.dice");
	Permission randomNumber = new Permission("rtd.randomnumber");
	
	Random r = new Random();
	
	@Override
	public void onEnable() {
		Bukkit.getServer().getPluginManager().addPermission(dice);
		Bukkit.getServer().getPluginManager().addPermission(randomNumber);
	}
	
	public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
		if(cmd.getName().equalsIgnoreCase("dice")) {
			if(!cs.hasPermission(dice)) {
				cs.sendMessage(ChatColor.RED + "No permission!");
				return true;
			}
			int roll = r.nextInt(12);
			roll = Math.round(roll);
			cs.sendMessage(ChatColor.AQUA + "You rolled a " + ChatColor.GREEN + roll + ChatColor.AQUA + " on the dice." );
			return true;
		}else if(cmd.getName().equalsIgnoreCase("random")) {
			if(!cs.hasPermission(randomNumber)) {
				cs.sendMessage(ChatColor.RED + "No permission!");
				return true;
			}
			
			if(args.length == 0) {
				cs.sendMessage(ChatColor.RED + "You need to specify a max number! USAGE: /random <MAX>");
				return true;
			}
			
			int max;
		
			try {
				max = Integer.parseInt(args[0]);
			}catch(Exception e) {
				cs.sendMessage(ChatColor.RED + "Make sure that your max number is a number, and not a letter or symbol. USAGE: /random <MAX>");
				return true;
			}
			
			max = Math.round(max);
			int roll = r.nextInt(max);
			roll = Math.round(roll);
			
		}
		
		return true;
	}
	
	

}
