package me.pastelrobots.usefulcommands.commands;


import me.pastelrobots.usefulcommands.UsefulCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginLogger;


public class MemoryCommand implements CommandExecutor {
    Runtime r = Runtime.getRuntime();
    long memUsed = (r.totalMemory() - r.freeMemory()) / 1048576;
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
            }
            if(p.hasPermission("usefulcommands.memory")) {
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.BLUE + "Getting memory");
                }
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.GREEN + "Success: Server memory usage is being displayed!");
                }
                p.sendMessage(ChatColor.GOLD + "The server's Memory Usage: " + ChatColor.UNDERLINE + memUsed + "/" + Runtime.getRuntime().maxMemory());
            }

        } else {
            Bukkit.getLogger().info(ChatColor.GOLD + "The server's Memory Usage: " + ChatColor.UNDERLINE + memUsed + "/" + Runtime.getRuntime().maxMemory());
        }



        return true;
    }
}
