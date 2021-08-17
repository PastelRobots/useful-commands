package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MaxPlayersCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player p) {
            Utils.logInfo(ChatColor.BLUE + "Grabbing max players");
                Utils.logInfo(ChatColor.BLUE + "Success: Max Players were shown!");
                int mp = UsefulCommands.plugin.getServer().getMaxPlayers();
                p.sendMessage("Max Players:\n" + mp);
        }


        return true;
    }
}
