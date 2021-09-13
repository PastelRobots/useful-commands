package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class DiscordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player p) {
            Utils.logInfo(ChatColor.BLUE + "Grabbing discord");
            if(UsefulCommands.plugin.getConfig().getBoolean("socials.discord")) {
                Utils.logInfo(ChatColor.BLUE + "Success: Discord was shown!");
                p.sendMessage(ChatColor.BLUE + "Discord: " + UsefulCommands.plugin.getConfig().getString("socials.discordlink"));
            }
        }


        return true;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("discord")) {
            return null;
        }
        return null;
    }
}
