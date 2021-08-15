package me.pastelrobots.usefulcommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SmiteCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            if(p.hasPermission("usefulcommands.smite")) {
                if (args.length < 1) {
                    Location loc = p.getLocation();
                    p.getWorld().strikeLightning(loc);
                    p.sendMessage(ChatColor.RED + "Thou hath been smitten!");
                } else {
                    Player t = Bukkit.getPlayerExact(args[0]);
                    if(t instanceof Player) {
                        Location loc = t.getLocation();
                        if(p.hasPermission("usefulcommands.smite.others")) {
                            t.getWorld().strikeLightning(loc);
                            t.sendMessage(ChatColor.RED + "Thou hath been smitten!");
                            p.sendMessage(ChatColor.UNDERLINE + t.getName() + ChatColor.GREEN + " has been smited.");
                        }
                    }
                }
            }
        } else {

        }

        return true;
    }
}
