package me.pastelrobots.usefulcommands.commands;

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
            if (p.hasPermission("usefulcommands.weather")) {
                if (args.length < 1) {
                    p.sendMessage(ChatColor.RED + "Invalid arguments!");
                } else if (args[0] == "clear") {
                    p.setPlayerWeather(WeatherType.CLEAR);
                } else if (args[0] == "rain") {
                    p.setPlayerWeather(WeatherType.DOWNFALL);
                } else {
                    p.sendMessage(ChatColor.RED + "Invalid arguments!");
                }
            }
        }


        return true;
    }
}
