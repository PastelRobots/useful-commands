package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderchestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            Utils.logInfo("Checking perms");
            p.closeInventory();
            Utils.logInfo("Grabbing enderchest inventory");
            if(p.hasPermission("usefulcommands.enderchest")) {
                Utils.logInfo("Success: Player's echest is being displayed!");
                p.openInventory(p.getEnderChest());
            }
        }

        return true;
    }
}
