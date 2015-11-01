package me.tehkitti.VotingLinks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AListener
  implements Listener
{
  Main main;
  
  public AListener(Main plugin)
  {
    this.main = plugin;
  }
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onPlayerInteract(PlayerInteractEvent event)
  {
    Player player = event.getPlayer();
    if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) && (
      (event.getClickedBlock().getType() == Material.SIGN_POST) || 
      (event.getClickedBlock().getType() == Material.WALL_SIGN)))
    {
      Sign sign = (Sign)event.getClickedBlock().getState();
      String line1 = sign.getLine(0);
      if (line1.equalsIgnoreCase("[VotingLinks]"))
      {
        String line2 = sign.getLine(1);
        if (line2.equalsIgnoreCase("link1")) {
          if (this.main.getConfig().getBoolean("enablelink1"))
          {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD + 
              "Voting Link #1:");
            player.sendMessage(
              ChatColor.translateAlternateColorCodes('&', this.main
              .getConfig().getString("link1")));
          }
          else
          {
            player.sendMessage(ChatColor.RED + 
              "This link has been disabled in the config.yml!");
          }
        }
        if (line2.equalsIgnoreCase("link2")) {
          if (this.main.getConfig().getBoolean("enablelink2"))
          {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD + 
              "Voting Link #2:");
            player.sendMessage(
              ChatColor.translateAlternateColorCodes('&', this.main
              .getConfig().getString("link2")));
          }
          else
          {
            player.sendMessage(ChatColor.RED + 
              "This link has been disabled in the config.yml!");
          }
        }
        if (line2.equalsIgnoreCase("link3")) {
          if (this.main.getConfig().getBoolean("enablelink3"))
          {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD + 
              "Voting Link #3:");
            player.sendMessage(
              ChatColor.translateAlternateColorCodes('&', this.main
              .getConfig().getString("link3")));
          }
          else
          {
            player.sendMessage(ChatColor.RED + 
              "This link has been disabled in the config.yml!");
          }
        }
        if (line2.equalsIgnoreCase("link4")) {
          if (this.main.getConfig().getBoolean("enablelink4"))
          {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD + 
              "Voting Link #4:");
            player.sendMessage(
              ChatColor.translateAlternateColorCodes('&', this.main
              .getConfig().getString("link4")));
          }
          else
          {
            player.sendMessage(ChatColor.RED + 
              "This link has been disabled in the config.yml!");
          }
        }
        if (line2.equalsIgnoreCase("link5")) {
          if (this.main.getConfig().getBoolean("enablelink5"))
          {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD + 
              "Voting Link #5:");
            player.sendMessage(
              ChatColor.translateAlternateColorCodes('&', this.main
              .getConfig().getString("link5")));
          }
          else
          {
            player.sendMessage(ChatColor.RED + 
              "This link has been disabled in the config.yml!");
          }
        }
        if (line2.equalsIgnoreCase("link6")) {
          if (this.main.getConfig().getBoolean("enablelink6"))
          {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD + 
              "Voting Link #6:");
            player.sendMessage(
              ChatColor.translateAlternateColorCodes('&', this.main
              .getConfig().getString("link6")));
          }
          else
          {
            player.sendMessage(ChatColor.RED + 
              "This link has been disabled in the config.yml!");
          }
        }
        if (line2.equalsIgnoreCase("link7")) {
          if (this.main.getConfig().getBoolean("enablelink7"))
          {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD + 
              "Voting Link #7:");
            player.sendMessage(
              ChatColor.translateAlternateColorCodes('&', this.main
              .getConfig().getString("link7")));
          }
          else
          {
            player.sendMessage(ChatColor.RED + 
              "This link has been disabled in the config.yml!");
          }
        }
        if (line2.equalsIgnoreCase("link8")) {
          if (this.main.getConfig().getBoolean("enablelink8"))
          {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD + 
              "Voting Link #8:");
            player.sendMessage(
              ChatColor.translateAlternateColorCodes('&', this.main
              .getConfig().getString("link8")));
          }
          else
          {
            player.sendMessage(ChatColor.RED + 
              "This link has been disabled in the config.yml!");
          }
        }
        if (line2.equalsIgnoreCase("link9")) {
          if (this.main.getConfig().getBoolean("enablelink9"))
          {
            player.sendMessage(ChatColor.RED + ChatColor.BOLD + 
              "Voting Link #9:");
            player.sendMessage(
              ChatColor.translateAlternateColorCodes('&', this.main
              .getConfig().getString("link9")));
          }
          else
          {
            player.sendMessage(ChatColor.RED + 
              "This link has been disabled in the config.yml!");
          }
        }
      }
    }
  }
}
