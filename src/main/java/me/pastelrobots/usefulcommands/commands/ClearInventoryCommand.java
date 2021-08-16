package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearInventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        
        Utils.logInfo("Grabbing args");
        if(s instanceof Player p) {
            
            Utils.logInfo("Checking args");
            if (args.length == 0) {
                
                Utils.logInfo(ChatColor.BLUE + "Checking perms");
                if (p.hasPermission("usefulcommands.ci")) {
                    
                    Utils.logInfo(ChatColor.BLUE + "Checking inventory");
                    if (p.getInventory().isEmpty()) {

                        Utils.logInfo(ChatColor.GOLD + "Failed to clear inventory as sender's inventory was already empty!");
                        p.sendMessage(ChatColor.RED + "Your inventory is already empty!");
                    } else {
                        p.sendMessage(ChatColor.GREEN + "Emptied your inventory!");
                        p.getInventory().clear();
                    }
                }
            } else {
                
                Utils.logInfo("Grabbing target");
                Player t = Bukkit.getPlayerExact(args[0]);
                if(t instanceof Player) {
                    
                    Utils.logInfo("Checking perms");
                    if (t.hasPermission("usefulcommands.ci.others")) {
                        
                        Utils.logInfo("Checking inventory");
                        if (t.getInventory().isEmpty()) {

                            Utils.logInfo(ChatColor.GOLD + "Failed to clear inventory as target's inventory was already empty!");
                            p.sendMessage(ChatColor.RED + "Target's inventory is already empty!");
                        } else {
                            Utils.logInfo(ChatColor.BLUE + "Success: Target's inventory was cleared!!");
                            p.sendMessage(ChatColor.GREEN + "Emptied the inventory of " + ChatColor.UNDERLINE + t.getName() );
                            t.getInventory().clear();
                        }
                    }
                }
            }
        } else {
            Utils.logInfo(ChatColor.GOLD + "Failed to kick as sender isn't a player!");
            Bukkit.getLogger().warning(ChatColor.GOLD + "Only players can run this command.");
        }


        return true;
    }
}
