package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player p) {
            Utils.logInfo(ChatColor.BLUE + "Grabbing rules");
            if(UsefulCommands.plugin.getConfig().getBoolean("rules.enabled") == true) {
                Utils.logInfo(ChatColor.BLUE + "Success: Rules were shown!");
                p.sendMessage(UsefulCommands.plugin.getConfig().getString("rules.msg"));
            }
        }


        return true;
    }
}
