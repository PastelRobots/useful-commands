package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if (s instanceof Player) {
            Player p = (Player) s;
            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().info(ChatColor.BLUE + "Checking args");
            }
            if (args.length == 0) {
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.BLUE + "Checking vulnerability");
                }
                if(p.isInvulnerable()) {
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                    }
                if (p.hasPermission("usefulcommands.god")) {
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player is no longer invulnerable!");
                    }
                    p.sendMessage(ChatColor.RED + "You are no longer invulnerable..");
                    p.setInvulnerable(false);
                }
                } else {
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player is now invulnerable!");
                    }
                    p.sendMessage(ChatColor.GREEN + "You are now invulnerable..");
                    p.setInvulnerable(true);
                }
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                }
                    if(p.hasPermission("usefulcommands.god.others")) {
                        if(target.isInvulnerable()) {
                            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                                Bukkit.getLogger().info(ChatColor.GREEN + "Success: Target is no longer invulnerable!");
                            }
                            p.sendMessage(ChatColor.RED.UNDERLINE + target.getName() + ChatColor.RED + " is now no longer invulnerable");
                            target.setInvulnerable(false);;
                        } else {
                            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                                Bukkit.getLogger().info(ChatColor.GREEN + "Success: Target is now invulnerable!");
                            }
                            p.sendMessage(ChatColor.GREEN.UNDERLINE + target.getName() + ChatColor.RED + " is now invulnerable");
                            target.setInvulnerable(true);
                        }
                    }
                }
        }
        return true;
        }
    }
