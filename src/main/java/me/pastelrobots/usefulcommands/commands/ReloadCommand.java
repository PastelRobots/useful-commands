package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player p) {
            if(p.hasPermission("usefulcommands.reload")) {
                UsefulCommands.plugin.reloadConfig();
                UsefulCommands.plugin.getPluginLoader().disablePlugin(UsefulCommands.plugin);
                UsefulCommands.plugin.getPluginLoader().enablePlugin(UsefulCommands.plugin);
                p.sendMessage(ChatColor.GREEN + "Config reloaded!");
                Bukkit.getLogger().info(ChatColor.GREEN + "Config reloaded!");
            }
        } else {
            UsefulCommands.plugin.reloadConfig();
            UsefulCommands.plugin.getPluginLoader().disablePlugin(UsefulCommands.plugin);
            UsefulCommands.plugin.getPluginLoader().enablePlugin(UsefulCommands.plugin);
            Bukkit.getLogger().info(ChatColor.GREEN + "Config reloaded!");
        }



        return true;
    }
}
