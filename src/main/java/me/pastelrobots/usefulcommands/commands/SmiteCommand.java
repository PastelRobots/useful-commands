package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.rmi.CORBA.Util;

public class SmiteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            Utils.logInfo("Checking perms");
            if(p.hasPermission("usefulcommands.smite")) {
                Utils.logInfo(ChatColor.BLUE + "Checking args");
                if (args.length < 1) {
                    Location loc = p.getLocation();
                    Utils.logInfo("Success: Player was smitten!");
                    p.getWorld().strikeLightning(loc);
                    p.sendMessage(ChatColor.RED + "Thou hath been smitten!");
                } else {
                    Player t = Bukkit.getPlayerExact(args[0]);
                    if(t instanceof Player) {
                        Location loc = t.getLocation();
                        Utils.logInfo("Checking perms");
                        if(p.hasPermission("usefulcommands.smite.others")) {
                            t.getWorld().strikeLightning(loc);
                            Utils.logInfo(ChatColor.GREEN + "Success: Target was smitten!");
                            t.sendMessage(ChatColor.RED + "Thou hath been smitten!");
                            p.sendMessage(ChatColor.UNDERLINE + t.getName() + ChatColor.GREEN + " has been smited.");
                        }
                    }
                }
            }
        } else {
            Utils.logInfo("Only a player can execute this command.");
        }
        return true;
    }
}
