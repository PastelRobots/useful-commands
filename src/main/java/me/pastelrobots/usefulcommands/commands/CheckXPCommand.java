package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckXPCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if (s instanceof Player) {
            Player p = (Player) s;
            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().info(ChatColor.BLUE + "Checking args");
            }
            if (args.length == 0) {
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                }
                if (p.hasPermission("usefulcommands.xp")) {
                    p.sendMessage(ChatColor.YELLOW.UNDERLINE + p.getName() + ChatColor.YELLOW + " has " + ChatColor.YELLOW.UNDERLINE + p.getLevel() + " levels");
                }
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                }
                if (p.hasPermission("usefulcommands.xp.others")) {
                    if (target instanceof Player) {
                        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                            Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player's xp is being displayed!");
                        }
                        p.sendMessage(ChatColor.YELLOW.UNDERLINE + target.getName() + ChatColor.YELLOW + " has " + ChatColor.YELLOW.UNDERLINE + target.getLevel() + " levels");
                    } else {
                        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                            Bukkit.getLogger().warning(ChatColor.GOLD + "Failed to check xp as invalid arguments were sent");
                        }
                        p.sendMessage(ChatColor.RED + "\"" + target.getName() + "\" does not exist/is offline.");
                    }
                }
            }
        }
        return true;
    }
}

