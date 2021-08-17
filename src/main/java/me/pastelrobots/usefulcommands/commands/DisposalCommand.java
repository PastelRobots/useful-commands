package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DisposalCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player p) {
            Utils.logInfo(ChatColor.BLUE + "Checking perms");
            if(p.hasPermission("usefulcommands.disposal")) {
                Utils.logInfo(ChatColor.BLUE + "Closing current inventory");
                p.closeInventory();
                Utils.logInfo(ChatColor.BLUE + "Success: Disposal GUI is open!");
                p.openInventory(UsefulCommands.plugin.getServer().createInventory(p, 27, "Disposal"));
            }
        }


        return true;
    }
}
