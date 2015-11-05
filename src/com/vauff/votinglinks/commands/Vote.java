package com.vauff.votinglinks.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.vauff.votinglinks.core.Main;

public class Vote implements CommandExecutor
{
	private Main main;
	
	public Vote(Main plugin)
	{
		main = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args)
	{
		if (commandlabel.equalsIgnoreCase("vote"))
		{
			if (sender.hasPermission("votinglinks.vote"))
			{
				for (int i = 0; i < main.getConfig().getStringList("links").size(); i++)
				{
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getStringList("links").get(i)));
				}
			}
			else
			{
				sender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
			}
		}
		return true;
	}
}