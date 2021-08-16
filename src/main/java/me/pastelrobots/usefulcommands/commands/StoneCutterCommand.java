package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class StoneCutterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player p) {
            Utils.logInfo(ChatColor.BLUE + "Checking perms");
            if(p.hasPermission("usefulcommands.stonecutter")) {
                Utils.logInfo(ChatColor.BLUE + "Grabbing stonecutter inventory");
                Inventory sc = Bukkit.createInventory(p, InventoryType.STONECUTTER);
                Utils.logInfo(ChatColor.BLUE + "Closing current inventory");
                p.closeInventory();
                Utils.logInfo(ChatColor.BLUE + "Success: Stonecutter inventory is open!!");
                p.openInventory(sc);
            }
        } else {
            Utils.logInfo(ChatColor.GOLD + "Failed to kick as sender is not a player!");
            Bukkit.getLogger().warning(ChatColor.GOLD + "Only players can run this command.");
        }
        return true;
    }
}
