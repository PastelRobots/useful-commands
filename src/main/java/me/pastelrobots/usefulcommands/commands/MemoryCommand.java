package me.pastelrobots.usefulcommands.commands;


import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginLogger;


public class MemoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        Runtime r = Runtime.getRuntime();
        long memUsed = (r.totalMemory() - r.freeMemory()) / 1048576;
        if(s instanceof Player) {
            Player p = (Player) s;
            Utils.logInfo(ChatColor.BLUE + "Checking perms");
            if(p.hasPermission("usefulcommands.memory")) {
                Utils.logInfo(ChatColor.BLUE + "Getting memory");
                Utils.logInfo(ChatColor.BLUE + "Success: Server Memory is being displayed!");
                p.sendMessage(ChatColor.GOLD + "The server's Memory Usage: " + ChatColor.UNDERLINE + memUsed + "mb");
        } else {
                Utils.logInfo(ChatColor.BLUE + "Success: Server Memory is being displayed!");
            Bukkit.getLogger().info(ChatColor.GOLD + "The server's Memory Usage: " + ChatColor.UNDERLINE + memUsed + "mb");
        }




    }
        return true;
}

}
