package me.pastelrobots.usefulcommands.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            if (p.hasPermission("usefulcommands.time")) {
                if (args.length < 1) {
                    p.sendMessage(ChatColor.RED + "Invalid arguments!");
                } else {
                    String time = args[0];
                    long timeLong = Long.parseLong(time);
                    p.setPlayerTime(timeLong, false);
                }
            }
        }


        return true;
    }
}
