package com.vauff.votinglinks.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.vauff.votinglinks.core.Main;

public class VLAbout implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args)
	{
		if (commandlabel.equalsIgnoreCase("vlabout"))
		{
			if (sender.hasPermission("votinglinks.about"))
			{
				sender.sendMessage(ChatColor.GREEN + "You are using VotingLinks " + ChatColor.RED + "v" + Main.version + ChatColor.GREEN + " created by Vauff");
				sender.sendMessage(ChatColor.AQUA + "http://dev.bukkit.org/bukkit-plugins/votinglinks/");
			}
			else
			{
				sender.sendMessage(ChatColor.DARK_RED + "You do not have access to that command.");
			}
		}
		return true;
	}
}