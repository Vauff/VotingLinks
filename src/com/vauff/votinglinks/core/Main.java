package com.vauff.votinglinks.core;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.io.Files;
import com.vauff.votinglinks.commands.VLAbout;
import com.vauff.votinglinks.commands.VLReload;
import com.vauff.votinglinks.commands.Vote;
import com.vauff.votinglinks.listeners.SignListener;

public class Main extends JavaPlugin
{
	public static String version = "3.0";

	public void onEnable()
	{
		getConfig().options().copyDefaults(true);
		saveConfig();
		getServer().getPluginManager().registerEvents(new SignListener(this), this);
		getCommand("vote").setExecutor(new Vote(this));
		getCommand("vlabout").setExecutor(new VLAbout());
		getCommand("vlreload").setExecutor(new VLReload(this));

		if (getConfig().getInt("dont-ever-change-this") != 2)
		{
			ConsoleCommandSender console = getServer().getConsoleSender();
			File config = new File(getDataFolder(), "config.yml");
			File configbackup = new File(getDataFolder(), "config-backup.yml");

			console.sendMessage("[VotingLinks]" + ChatColor.DARK_RED + " IMPORTANT:");
			console.sendMessage("[VotingLinks]" + ChatColor.RED + " Your configuration has been reset due to an update that added new configuration options");
			console.sendMessage("[VotingLinks]" + ChatColor.RED + " Your old configuration file is stored in config-backup.yml");
			console.sendMessage("[VotingLinks]" + ChatColor.RED + " You can use this file as reference to get back your config to how it was before");

			try
			{
				Files.copy(config, configbackup);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}

			config.delete();
			saveDefaultConfig();
		}

		if (getConfig().getBoolean("announcements"))
		{
			getServer().getScheduler().runTaskTimer(this, new Runnable()
			{
				public int countdowntime = getConfig().getInt("announcement-delay");

				public void run()
				{
					if (countdowntime != 1)
					{
						countdowntime -= 1;
					}
					else
					{
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("announcement-message")));
						countdowntime = getConfig().getInt("announcement-delay");
					}
				}
			}, 0L, 20L);
		}
	}
}