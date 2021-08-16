package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player p) {
            Utils.logInfo(ChatColor.BLUE + "Checking perms");
            if(p.hasPermission("usefulcommands.ping")) {
                Utils.logInfo(ChatColor.BLUE + "Success: Player's ping is being displayed!");
                p.sendMessage(ChatColor.GOLD + "Your ping is " + ChatColor.GREEN + p.getPing() + "ms");
            }
        }



        return true;
    }
}
