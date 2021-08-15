package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Grabbing args");
        }
        if (s instanceof Player) {
            Player p = (Player) s;
            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().info(ChatColor.BLUE + "Checking args");
            }
            if (args.length == 0) {
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                }
                if (p.hasPermission("usefulcommands.heal")) {
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.BLUE + "Checking playerhealth");
                    }
                    if (p.getHealth() == 20) {
                        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                            Bukkit.getLogger().warning(ChatColor.GOLD + "Failed to heal as sender has max health!");
                        }
                        p.sendMessage(ChatColor.RED + "You already have max health " + ChatColor.UNDERLINE + p.getName());
                    } else {
                        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                            Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player has been healed");
                        }
                        p.sendMessage(ChatColor.GREEN + "Healed " + ChatColor.UNDERLINE + p.getName());
                        p.setHealth(20);
                    }
                }
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                    }
                    if (p.hasPermission("usefulcommands.heal.others")) {

                        if (target.getHealth() == 20) {
                            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                                Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player is now flying");
                            }
                            p.sendMessage(ChatColor.GREEN + "Healed " + ChatColor.UNDERLINE + target.getName());
                            target.setHealth(20);
                        } else {
                            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                                Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player is now flying");
                            }
                            p.sendMessage(ChatColor.GREEN + "Healed " + ChatColor.UNDERLINE + target.getName());
                            target.setHealth(20);
                        }
                    }
                } else {
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().warning(ChatColor.GOLD + "Failed to kick as invalid arguments were sent");
                    }
                    p.sendMessage(ChatColor.RED + "\"" + target.getName() + "\" does not exist/is offline.");
                }
            }
        } else {
            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().warning(ChatColor.GOLD + "Failed to kick as sender was not a player!");
            }
            Bukkit.getLogger().warning(ChatColor.GOLD + "Only players can run this command.");
        }
        return true;
    }
}

