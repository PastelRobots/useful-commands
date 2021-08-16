package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        Utils.logInfo("Grabbing args");
        if (s instanceof Player) {
            Player p = (Player) s;
            Utils.logInfo("Checking args");
            if (args.length == 0) {
                Utils.logInfo("Checking perms");
                if (p.hasPermission("usefulcommands.feed")) {
                    Utils.logInfo("Checking foodlevels");
                    if (p.getFoodLevel() == 20) {
                        Utils.logInfo(ChatColor.GOLD + "Failed to feed as sender's inventory was already empty!");
                        p.sendMessage(ChatColor.RED + "You already have max food levels " + ChatColor.UNDERLINE + p.getName());
                    } else {
                        Utils.logInfo("Success: Player has been fed");
                        p.sendMessage(ChatColor.GREEN + "Fed " + ChatColor.UNDERLINE + p.getName());
                        p.setFoodLevel(20);
                    }
                }
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {
                    Utils.logInfo("Checking perms");
                    if (p.hasPermission("usefulcommands.feed.others")) {

                        if (target.getFoodLevel() == 20) {
                            Utils.logInfo("Success: Player was fed");
                            p.sendMessage(ChatColor.GREEN + "Fed " + ChatColor.UNDERLINE + target.getName());
                            target.setFoodLevel(20);
                        } else {
                            Utils.logInfo("Success: Player was fed");
                            p.sendMessage(ChatColor.GREEN + "Fed " + ChatColor.UNDERLINE + target.getName());
                            target.setFoodLevel(20);
                        }
                    }
                } else {
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().warning(ChatColor.GOLD + "Failed to feed as invalid arguments were sent");
                    }
                    p.sendMessage(ChatColor.RED + "\"" + target.getName() + "\" does not exist/is offline.");
                }
            }
        } else {
            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().warning(ChatColor.GOLD + "Failed to fed as sender was not a player!");
            }
            Bukkit.getLogger().warning(ChatColor.GOLD + "Only players can run this command.");
        }
        return true;
    }
}
