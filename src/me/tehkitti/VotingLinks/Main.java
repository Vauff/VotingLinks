package me.tehkitti.VotingLinks;

import java.io.File;
import java.io.PrintStream;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Main
  extends JavaPlugin
{
  public static String v = "2.0.0";
  
  public void onDisable()
  {
    pluginInfo("of VotingLinks Disabled!");
  }
  
  public void onEnable()
  {
    pluginInfo("of VotingLinks Enabled!");
    getConfig().options().copyDefaults(true);
    saveConfig();
    if (getConfig().getInt("dont-ever-change-this") != 1)
    {
      ConsoleCommandSender console = getServer().getConsoleSender();
      console.sendMessage("[VotingLinks]" + ChatColor.DARK_RED + 
        " IMPORTANT:");
      console.sendMessage("[VotingLinks]" + 
        ChatColor.RED + 
        " Configuration has been reset due to a update that added new configuration options.");
      File file = new File(getDataFolder(), "config.yml");
      file.delete();
      saveDefaultConfig();
    }
    getServer().getScheduler().runTaskTimerAsynchronously(this, new Runnable()
    {
      public int countdowntime = Main.this.getConfig()
        .getInt("announcement-delay");
      
      public void run()
      {
        if (this.countdowntime != 1)
        {
          this.countdowntime -= 1;
        }
        else
        {
          Bukkit.broadcastMessage(
            ChatColor.translateAlternateColorCodes(
            '&', 
            Main.this.getConfig().getString(
            "reminder")));
          this.countdowntime = Main.this.getConfig().getInt(
            "announcement-delay");
        }
      }
    }, 0L, 20L);
  }
  
  public static void pluginInfo(String message)
  {
    System.out.println("[VotingLinks] Version " + v + " " + message);
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandlabel, String[] args)
  {
    if (commandlabel.equalsIgnoreCase("vote"))
    {
      ConsoleCommandSender console = getServer().getConsoleSender();
      if ((sender instanceof ConsoleCommandSender))
      {
        console.sendMessage(ChatColor.translateAlternateColorCodes('&', 
          getConfig().getString("thank-you-message")));
        console.sendMessage(ChatColor.translateAlternateColorCodes('&', 
          getConfig().getString("link1")));
        console.sendMessage(ChatColor.translateAlternateColorCodes('&', 
          getConfig().getString("link2")));
        console.sendMessage(ChatColor.translateAlternateColorCodes('&', 
          getConfig().getString("link3")));
        console.sendMessage(ChatColor.translateAlternateColorCodes('&', 
          getConfig().getString("link4")));
        console.sendMessage(ChatColor.translateAlternateColorCodes('&', 
          getConfig().getString("link5")));
        console.sendMessage(ChatColor.translateAlternateColorCodes('&', 
          getConfig().getString("link6")));
        console.sendMessage(ChatColor.translateAlternateColorCodes('&', 
          getConfig().getString("link7")));
        console.sendMessage(ChatColor.translateAlternateColorCodes('&', 
          getConfig().getString("link8")));
        console.sendMessage(ChatColor.translateAlternateColorCodes('&', 
          getConfig().getString("link9")));
      }
      if (((sender instanceof Player)) && 
        (sender.hasPermission("votinglinks.vote")))
      {
        sender.sendMessage(ChatColor.translateAlternateColorCodes(
          '&', getConfig().getString("thank-you-message")));
        sender.sendMessage(ChatColor.translateAlternateColorCodes(
          '&', getConfig().getString("link1")));
        sender.sendMessage(ChatColor.translateAlternateColorCodes(
          '&', getConfig().getString("link2")));
        sender.sendMessage(ChatColor.translateAlternateColorCodes(
          '&', getConfig().getString("link3")));
        sender.sendMessage(ChatColor.translateAlternateColorCodes(
          '&', getConfig().getString("link4")));
        sender.sendMessage(ChatColor.translateAlternateColorCodes(
          '&', getConfig().getString("link5")));
        sender.sendMessage(ChatColor.translateAlternateColorCodes(
          '&', getConfig().getString("link6")));
        sender.sendMessage(ChatColor.translateAlternateColorCodes(
          '&', getConfig().getString("link7")));
        sender.sendMessage(ChatColor.translateAlternateColorCodes(
          '&', getConfig().getString("link8")));
        sender.sendMessage(ChatColor.translateAlternateColorCodes(
          '&', getConfig().getString("link9")));
      }
      if (!sender.hasPermission("votinglinks.vote")) {
        sender.sendMessage(ChatColor.RED + "No permission.");
      }
    }
    if (commandlabel.equalsIgnoreCase("vlabout"))
    {
      ConsoleCommandSender console = getServer().getConsoleSender();
      if (((sender instanceof Player)) && 
        (sender.hasPermission("votinglinks.about")))
      {
        sender.sendMessage(ChatColor.GREEN + 
          "You Are Using VotingLinks Version " + 
          ChatColor.RED + v + ChatColor.GREEN + 
          " Created By TehKitti.");
        sender.sendMessage(ChatColor.AQUA + 
          "http://dev.bukkit.org/bukkit-plugins/votinglinks/");
      }
      if ((sender instanceof ConsoleCommandSender))
      {
        console.sendMessage(ChatColor.GREEN + 
          "You Are Using VotingLinks Version " + ChatColor.RED + 
          v + ChatColor.GREEN + " Created By TehKitti.");
        console.sendMessage(ChatColor.AQUA + 
          "http://dev.bukkit.org/bukkit-plugins/votinglinks/");
      }
      if (!sender.hasPermission("votinglinks.about")) {
        sender.sendMessage(ChatColor.RED + "No permission.");
      }
    }
    return true;
  }
}
