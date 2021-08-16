package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
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
        if(s instanceof Player p) {
            Utils.logInfo(ChatColor.BLUE + "Checking perms");
            if (p.hasPermission("usefulcommands.weather")) {
                Utils.logInfo(ChatColor.BLUE + "Checking args");
                if (args.length < 1) {
                    p.sendMessage(ChatColor.RED + "Invalid arguments!");
                } else if (args[0].toLowerCase() == "clear") {
                    Utils.logInfo(ChatColor.BLUE + "Success: World weather was changed.");
                    p.setPlayerWeather(WeatherType.CLEAR);
                } else if (args[0].toLowerCase() == "rain") {
                    Utils.logInfo(ChatColor.BLUE + "Success: World weather was changed.");
                    p.setPlayerWeather(WeatherType.DOWNFALL);
                } else {
                    p.sendMessage(ChatColor.RED + "Invalid arguments!");
                }
            }
        }


        return true;
    }
}
