package me.tehkitti.VoteLinks;

import java.io.PrintStream;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class VoteLinks
  extends JavaPlugin
{
  private static final boolean Material = false;
  
  public void onDisable()
  {
    pluginInfo("of VotingLinks Disabled!");
  }
  
  public void onEnable()
  {
    pluginInfo("of VotingLinks Enabled!");
    getConfig().options().copyDefaults(true);
    saveConfig();
  }
  
  public static void pluginInfo(String message)
  {
    String v = "1.0.0";
    
    System.out.println("[VotingLinks] Version " + v + " " + message);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args)
  {
    Player player = (Player)sender;
    if (commandlabel.equalsIgnoreCase("vlabout"))
    {
      String v = ChatColor.RED + "1.0.0";
      player.sendMessage(ChatColor.GREEN + "You Are Using VotingLinks Version " + v + ChatColor.GREEN + " Created By TehKitti.");
      player.sendMessage(ChatColor.AQUA + "http://dev.bukkit.org/bukkit-plugins/votinglinks/");
    }
    if (commandlabel.equalsIgnoreCase("vote"))
    {
      player.sendMessage(ChatColor.GOLD + getConfig().getString("thank-you-message"));
      player.sendMessage(getConfig().getString("link1"));
      player.sendMessage(getConfig().getString("link2"));
      player.sendMessage(getConfig().getString("link3"));
      player.sendMessage(getConfig().getString("link4"));
      player.sendMessage(getConfig().getString("link5"));
      player.sendMessage(getConfig().getString("link6"));
      player.sendMessage(getConfig().getString("link7"));
      player.sendMessage(getConfig().getString("link8"));
      player.sendMessage(getConfig().getString("link9"));
    }
    return true;
  }
}
