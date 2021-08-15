package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearInventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Grabbing args");
        }
        if(s instanceof Player) {
            Player p = (Player) s;
            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().info(ChatColor.BLUE + "Checking args");
            }
            if (args.length == 0) {
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                }
                if (p.hasPermission("usefulcommands.ci")) {
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.BLUE + "Checking inventory");
                    }
                    if (p.getInventory().isEmpty()) {
                        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                            Bukkit.getLogger().warning(ChatColor.GOLD + "Failed to kick as sender's inventory was already empty");
                        }
                        p.sendMessage(ChatColor.RED + "Your inventory is already empty!");
                    } else {
                        p.sendMessage(ChatColor.GREEN + "Emptied your inventory!");
                        p.getInventory().clear();
                    }
                }
            } else {
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.BLUE + "Grabbing target");
                }
                Player t = Bukkit.getPlayerExact(args[0]);
                if(t instanceof Player) {
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                    }
                    if (t.hasPermission("usefulcommands.ci.others")) {
                        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                            Bukkit.getLogger().info(ChatColor.BLUE + "Checking inventory");
                        }
                        if (t.getInventory().isEmpty()) {
                            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                                Bukkit.getLogger().warning(ChatColor.GOLD + "Failed to clear inventory as target's inventory was already empty");
                            }
                            p.sendMessage(ChatColor.RED + "Target's inventory is already empty!");
                        } else {
                            p.sendMessage(ChatColor.GREEN + "Emptied the inventory of " + ChatColor.UNDERLINE + t.getName() );
                            t.getInventory().clear();
                        }
                    }
                }
            }
        } else {
            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().warning(ChatColor.GOLD + "Failed to clear inventory as sender is not a player");
            }
            Bukkit.getLogger().warning(ChatColor.GOLD + "Only players can run this command.");
        }


        return true;
    }
}
