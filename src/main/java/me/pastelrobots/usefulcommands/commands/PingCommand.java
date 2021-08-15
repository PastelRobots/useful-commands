package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
            }
            if(p.hasPermission("usefulcommands.ping")) {
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player's ping is being displayed!");
                }
                p.sendMessage(ChatColor.GOLD + "Your ping is " + ChatColor.GREEN + p.getPing() + "ms");
            }
        }



        return true;
    }
}
