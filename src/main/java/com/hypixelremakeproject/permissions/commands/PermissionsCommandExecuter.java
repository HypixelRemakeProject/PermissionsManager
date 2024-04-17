package com.hypixelremakeproject.permissions.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.hypixelremakeproject.permissions.PermissionsManager;

public class PermissionsCommandExecuter implements CommandExecutor {
	
	 private PermissionsManager plugin;
	 
	 public PermissionsCommandExecuter(PermissionsManager plugin) {
		 this.plugin = plugin;
	 }

	 @Override
	 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		 if (cmd.getName().equalsIgnoreCase("permissions")) {
			 if (!(sender.hasPermission("pm.admin"))) {
				 sender.sendMessage(ChatColor.WHITE + "You have to be and " + ChatColor.RED + "ADMIN " + ChatColor.WHITE + "to use this command.");
				 return true;
			 }
			 
			 if (args.length == 0) {
				 sender.sendMessage(ChatColor.AQUA + "Usage: " + ChatColor.YELLOW + "/permissions <add|remove|set|get|prefic|suffix> [args]");
				 return true;
			 }
			 
			 switch (args[0].toLowerCase()) {
				 case "add":
					 return handleAdd(sender, args);
				 case "remove":
					 return handleRemove(sender, args);
				 case "set":
					 return handleSet(sender, args);
				 case "get":
					 return handleGet(sender, args);
				 case "prefix":
					 return handlePrefix(sender, args);
				 case "suffix":
					 return handleSuffix(sender, args);
				 default:
					 sender.sendMessage(ChatColor.WHITE + "Unknown command, maybe /help will help you?");
					 return true;
			 }
		 }
		 return false;
	 }
	 
	 public boolean handleAdd(CommandSender sender, String args[]) {
		 if (args.length < 2) {
			 sender.sendMessage(ChatColor.AQUA + "Usage: " + ChatColor.YELLOW + "/permissions <add|remove|set|get|prefic|suffix> [args]");
			 return true;
		 }
		 
		 sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.WHITE + args[1] + ChatColor.GREEN + "added successfully");
		 return true;
	 }
	 
	private boolean handleRemove(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(ChatColor.AQUA + "Usage: " + ChatColor.YELLOW + "/permissions remove <player>");
            return true;
        }
        sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.WHITE + args[1] + ChatColor.GREEN + " removed successfully.");
        return true;
    }
	
	private boolean handleSet(CommandSender sender, String[] args) {
        if (args.length < 3) {
            sender.sendMessage(ChatColor.AQUA + "Usage: " + ChatColor.YELLOW + "/permissions set <player> <permission>");
            return true;
        }
        sender.sendMessage(ChatColor.GREEN + "Permission " + ChatColor.WHITE + args[2] + ChatColor.GREEN + " set for player " + args[1] + ".");
        return true;
    }
	
	private boolean handleGet(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(ChatColor.AQUA + "Usage: " + ChatColor.YELLOW + "/permissions get <player>");
            return true;
        }
        sender.sendMessage(ChatColor.GREEN + "Player " + ChatColor.WHITE + args[1] + ChatColor.GREEN + " has permissions: [list_of_permissions].");
        return true;
    }
	
	private boolean handlePrefix(CommandSender sender, String[] args) {
        if (args.length < 3) {
            sender.sendMessage(ChatColor.WHITE + "Usage: " + ChatColor.YELLOW + "/permissions prefix <group|player> <prefix>");
            return true;
        }
        String target = args[1].toLowerCase();
        String name = args[2];
        String prefix = args[3];

        if (target.equals("group")) {
            plugin.setGroupPrefix(name, prefix);
            sender.sendMessage(ChatColor.GREEN + "Prefix '" + prefix + "' set for group " + name + ".");
        } else if (target.equals("player")) {
            plugin.setPlayerPrefix(name, prefix);
            sender.sendMessage(ChatColor.GREEN + "Prefix '" + prefix + "' set for player " + name + ".");
        } else {
            sender.sendMessage(ChatColor.RED + "Invalid target. Use 'group' or 'player'.");
        }
        return true;
    }
	
	private boolean handleSuffix(CommandSender sender, String[] args) {
        if (args.length < 3) {
            sender.sendMessage(ChatColor.YELLOW + "Usage: /permissions suffix <group|player> <suffix>");
            return true;
        }
        String target = args[1].toLowerCase();
        String name = args[2];
        String suffix = args[3];

        if (target.equals("group")) {
            plugin.setGroupSuffix(name, suffix);
            sender.sendMessage(ChatColor.GREEN + "Suffix '" + suffix + "' set for group " + name + ".");
        } else if (target.equals("player")) {
            plugin.setPlayerSuffix(name, suffix);
            sender.sendMessage(ChatColor.GREEN + "Suffix '" + suffix + "' set for player " + name + ".");
        } else {
            sender.sendMessage(ChatColor.RED + "Invalid target. Use 'group' or 'player'.");
        }
        return true;
    }
}
