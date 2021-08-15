package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CraftingTableCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            Utils.logInfo("Checking Perms");
            if(p.hasPermission("usefulcommands.craft")) {
                Utils.logInfo("Grabbing crafting table inventory");
                Utils.logInfo("Success: Player's crafting table is being displayed!");
                p.openWorkbench(null, true);
            }

        }


        return true;
    }
}
