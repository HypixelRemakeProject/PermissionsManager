package com.hypixelremakeproject.permissions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.hypixelremakeproject.permissions.commands.PermissionsCommandExecuter;

import java.util.Map;
import java.util.HashMap;

public class PermissionsManager extends JavaPlugin {
	
	private Map<String, String> playerPrefixes = new HashMap<>();
	private Map<String, String> playerSuffixes = new HashMap<>();
	private Map<String, String> groupPrefixes = new HashMap<>();
	private Map<String, String> groupSuffixes = new HashMap<>();

	@Override
	public void onEnable() {
		getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[PERMISSIONSMANAGER] " + ChatColor.GREEN + "Plugin has been enabled!");
		this.getCommand("permissions").setExecutor(new PermissionsCommandExecuter(this));
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[PERMISSIONSMANAGER] " + ChatColor.RED + "Plugin has been disabled...");
	}
	
	public void setPlayerPrefix(String player, String prefix) {
		playerPrefixes.put(player, prefix);
	}
	
	public void setPlayerSuffix(String player, String suffix) {
		playerSuffixes.put(player, suffix);
	}
	
	public String getPlayerPrefix(String player) {
		return playerPrefixes.getOrDefault(player, " ");
	}
	
	public String getPlayerSuffixes(String player) {
		return playerSuffixes.getOrDefault(player, " ");
	}
	
	public void setGroupPrefix(String group, String prefix) {
		groupPrefixes.put(group, prefix);
	}
	
	public void setGroupSuffix(String group, String suffix) {
		groupSuffixes.put(group, suffix);
	}
	
	public String getGroupPrefix(String group) {
		return groupPrefixes.getOrDefault(group, " ");
	}
	
	public String getGroupSuffix(String group) {
		return groupSuffixes.getOrDefault(group, " ");
	}
}
