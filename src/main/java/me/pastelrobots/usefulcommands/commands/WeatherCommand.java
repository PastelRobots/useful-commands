package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
            }
            if (p.hasPermission("usefulcommands.weather")) {
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.BLUE + "Checking args");
                }
                if (args.length < 1) {
                    p.sendMessage(ChatColor.RED + "Invalid arguments!");
                } else if (args[0].toLowerCase() == "clear") {
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.GREEN + "Success: World weather was changed!");
                    }
                    p.setPlayerWeather(WeatherType.CLEAR);
                } else if (args[0].toLowerCase() == "rain") {
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.GREEN + "Success: World weather was changed!");
                    }
                    p.setPlayerWeather(WeatherType.DOWNFALL);
                } else {
                    p.sendMessage(ChatColor.RED + "Invalid arguments!");
                }
            }
        }


        return true;
    }
}
