package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

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
                        Bukkit.getLogger().info(ChatColor.BLUE + "Checking Perms");
                    }
                    if (p.hasPermission("usefulcommands.fly")) {
                        p.setAllowFlight(true);
                        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                            Bukkit.getLogger().info(ChatColor.BLUE + "Check flying status");
                        }
                        if (p.isFlying()) {
                            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                                Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player's fly has been disabled");
                            }
                            p.sendMessage(ChatColor.RED + "Disabled fly for " + ChatColor.UNDERLINE + p.getName());
                            p.setFlying(false);
                        } else {
                            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                                Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player is now flying");
                            }
                            p.sendMessage(ChatColor.GREEN + "Enabled fly for " + ChatColor.UNDERLINE + p.getName());
                            p.setFlying(true);
                        }
                    }
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.BLUE + "Checking command target");
                    }
                    if (target instanceof Player) {
                        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                            Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                        }
                        if (p.hasPermission("usefulcommands.fly.others")) {
                            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                                Bukkit.getLogger().info(ChatColor.BLUE + "Checking flying status");
                            }
                            if (target.isFlying()) {
                                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                                    Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player's fly has been disabled");
                                }
                                p.sendMessage(ChatColor.RED + "Disabled fly for " + ChatColor.UNDERLINE + target.getName());
                                target.setFlying(false);
                            } else {
                                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                                    Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player is now flying");
                                }
                                p.sendMessage(ChatColor.GREEN + "Enabled fly for " + ChatColor.UNDERLINE + target.getName());
                                target.setFlying(true);
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
