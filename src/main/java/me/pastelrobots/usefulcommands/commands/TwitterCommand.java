package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TwitterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if (s instanceof Player p) {
            Utils.logInfo(ChatColor.BLUE + "Grabbing rules");
            if (UsefulCommands.plugin.getConfig().getBoolean("socials.twitter")) {
                Utils.logInfo(ChatColor.BLUE + "Success: Twitter was shown!");
                p.sendMessage(ChatColor.AQUA + "Twitter: " + UsefulCommands.plugin.getConfig().getString("socials.twitterlink"));
            }
        }


        return true;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("twitter")) {
            return null;
        }
        return null;
    }
}
