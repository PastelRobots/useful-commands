package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player p) {
            Utils.logInfo(ChatColor.BLUE + "Checking perms");
            if (p.hasPermission("usefulcommands.time")) {
                Utils.logInfo(ChatColor.BLUE + "Checking args");
                if (args.length < 1) {
                    Utils.logInfo(ChatColor.GOLD + "Failed to change world time as sender sent invalid arguments!");
                    p.sendMessage(ChatColor.RED + "Invalid arguments!");
                } else {
                    Utils.logInfo(ChatColor.BLUE + "Success: World time was changed.");
                    String time = args[0];
                    long timeLong = Long.parseLong(time);
                    p.setPlayerTime(timeLong, false);
                }
            }
        }


        return true;
    }
}
