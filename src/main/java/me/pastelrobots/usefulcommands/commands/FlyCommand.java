package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
            if (s instanceof Player) {
                Player p = (Player) s;
                Utils.logInfo(ChatColor.BLUE + "Checking args");
                if (args.length == 0) {
                    Utils.logInfo(ChatColor.BLUE + "Checking perms");
                    if (p.hasPermission("usefulcommands.fly")) {
                        p.setAllowFlight(true);
                        Utils.logInfo(ChatColor.BLUE + "Checking flying status");
                        if (p.isFlying()) {
                            Utils.logInfo(ChatColor.BLUE + "Success: Player's fly is now disabled!");
                            p.sendMessage(ChatColor.RED + "Disabled fly for " + ChatColor.UNDERLINE + p.getName());
                            p.setFlying(false);
                        } else {
                            Utils.logInfo(ChatColor.BLUE + "Success: Player is now flying!");
                            p.sendMessage(ChatColor.GREEN + "Enabled fly for " + ChatColor.UNDERLINE + p.getName());
                            p.setFlying(true);
                        }
                    }
                } else {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if (target instanceof Player) {
                        Utils.logInfo(ChatColor.BLUE + "Checking perms");
                        if (p.hasPermission("usefulcommands.fly.others")) {
                            Utils.logInfo(ChatColor.BLUE + "Checking flying status");
                            if (target.isFlying()) {
                                Utils.logInfo(ChatColor.BLUE + "Success: Target's fly is now disabled!");
                                p.sendMessage(ChatColor.RED + "Disabled fly for " + ChatColor.UNDERLINE + target.getName());
                                target.setFlying(false);
                            } else {
                                Utils.logInfo(ChatColor.BLUE + "Success: Target is now flying!");
                                p.sendMessage(ChatColor.GREEN + "Enabled fly for " + ChatColor.UNDERLINE + target.getName());
                                target.setFlying(true);
                            }
                        }
                    } else {
                        Utils.logInfo(ChatColor.GOLD + "Failed to check xp as invalid arguments were sent!");
                        p.sendMessage(ChatColor.RED + "\"" + target.getName() + "\" does not exist/is offline.");
                    }
                }
            } else {
                Utils.logInfo(ChatColor.GOLD + "Failed to fly as command sender is not a player");
                Bukkit.getLogger().warning(ChatColor.GOLD + "Only players can run this command.");
            }
        return true;
    }
}
