package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GodCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if (s instanceof Player p) {
            Utils.logInfo(ChatColor.BLUE + "Checking args");
            if (args.length == 0) {
                Utils.logInfo(ChatColor.BLUE + "Checking god status");
                if(p.isInvulnerable()) {
                    Utils.logInfo(ChatColor.BLUE + "Checking perms");
                if (p.hasPermission("usefulcommands.god")) {
                    Utils.logInfo(ChatColor.BLUE + "Success: Player is no longer invulnerable!");
                    p.sendMessage(ChatColor.RED + "You are no longer invulnerable..");
                    p.setInvulnerable(false);
                }
                } else {
                    Utils.logInfo(ChatColor.BLUE + "Success: Player is now invulnerable!");
                    p.sendMessage(ChatColor.GREEN + "You are now invulnerable..");
                    p.setInvulnerable(true);
                }
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if(target instanceof Player) {
                Utils.logInfo(ChatColor.BLUE + "Checking perms");
                    if(p.hasPermission("usefulcommands.god.others")) {
                        if (target.isInvulnerable()) {
                            Utils.logInfo(ChatColor.BLUE + "Success: Target is no longer invulnerable!");
                            p.sendMessage(ChatColor.RED.UNDERLINE + target.getName() + ChatColor.RED + " is now no longer invulnerable");
                            target.setInvulnerable(false);
                        } else {
                            Utils.logInfo(ChatColor.BLUE + "Success: Target is now invulnerable!");
                            p.sendMessage(ChatColor.GREEN.UNDERLINE + target.getName() + ChatColor.RED + " is now invulnerable");
                            target.setInvulnerable(true);
                        }
                    }
                    } else {
                    Utils.logInfo(ChatColor.GOLD + "Failed to god as invalid arguments were sent!");
                }
                }
        }
        return true;
        }
    }
