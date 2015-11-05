package com.vauff.votinglinks.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.vauff.votinglinks.core.Main;

public class VLReload implements CommandExecutor
{
	private Main main;

	public VLReload(Main plugin)
	{
		main = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args)
	{
		if (commandlabel.equalsIgnoreCase("vlreload"))
		{
			if (sender.hasPermission("votinglinks.reload"))
			{
				main.reloadConfig();
				sender.sendMessage(ChatColor.AQUA + "VotingLinks configuration file reloaded successfully!");
			}
			else
			{
				sender.sendMessage(ChatColor.DARK_RED + "You do not have acccess to that command.");
			}
		}
		return true;
	}
}