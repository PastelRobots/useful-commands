package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MOTDCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player p) {
            Utils.logInfo(ChatColor.BLUE + "Grabbing motd");
                Utils.logInfo(ChatColor.BLUE + "Success: MOTD was shown!");
                String motd = UsefulCommands.plugin.getServer().getMotd();
                p.sendMessage("MOTD:\n" + motd);
        }


        return true;
    }
}
