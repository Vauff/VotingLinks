package com.vauff.votinglinks.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.vauff.votinglinks.core.Main;

public class SignListener implements Listener
{
	private Main main;

	public SignListener(Main plugin)
	{
		main = plugin;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerInteract(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();

		if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) && ((event.getClickedBlock().getType() == Material.SIGN_POST) || (event.getClickedBlock().getType() == Material.WALL_SIGN)))
		{
			Sign sign = (Sign) event.getClickedBlock().getState();
			String line1 = sign.getLine(0);

			if (line1.equalsIgnoreCase("[VotingLinks]"))
			{
				if (player.hasPermission("votinglinks.vote"))
				{
					String line2 = sign.getLine(1);

					if (line2.startsWith("link"))
					{
						for (int i = 0; i < main.getConfig().getStringList("links").size(); i++)
						{
							if (line2.equalsIgnoreCase("link" + (i + 1)))
							{
								player.sendMessage("" + ChatColor.RED + ChatColor.BOLD + "Voting Link " + (i + 1) + ":");
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getStringList("links").get(i)));
							}

						}
					}

					if (line2.equalsIgnoreCase("all"))
					{
						for (int i = 0; i < main.getConfig().getList("links").size(); i++)
						{
							player.sendMessage(ChatColor.translateAlternateColorCodes('&', main.getConfig().getStringList("links").get(i)));
						}
					}
				}
				else
				{
					player.sendMessage(ChatColor.DARK_RED + "You do not have access to that action.");
				}
			}
		}
	}
}