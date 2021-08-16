package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < args.length; i++) {
            sb.append(args[i] + 1).append(" ");
        }

        String reason = sb.toString().trim();

        if (s instanceof Player p) {

            Utils.logInfo(ChatColor.BLUE + "Checking args");
            if (args.length == 0) {
                Utils.logInfo(ChatColor.GOLD + "Failed to kick as invalid arguments were sent!");
                p.sendMessage(ChatColor.RED + "Invalid arguments");
            } else {
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target instanceof Player) {
                    Utils.logInfo(ChatColor.BLUE + "Checking perms");
                    if (p.hasPermission("usefulcommands.kick")) {
                        if (!target.isOp()) {
                            Utils.logInfo(ChatColor.BLUE + "Success: Target was kicked!");
                            p.sendMessage(ChatColor.GREEN + "Kicked " + ChatColor.UNDERLINE + target.getName());
                            target.kickPlayer(ChatColor.GOLD + "You have been kicked!\n" + ChatColor.RED + "You were kicked by " + ChatColor.RED.UNDERLINE + p.getName() + ChatColor.GREEN + "\nReason: " + ChatColor.GREEN.UNDERLINE + reason);
                        } else {
                            Utils.logInfo(ChatColor.GOLD + "Failed to kick as target is op!");
                            p.sendMessage(ChatColor.RED + "You can't kick " + ChatColor.UNDERLINE + target.getName());
                        }
                    }
                } else {
                    Utils.logInfo(ChatColor.GOLD + "Failed to kick as invalid arguments were sent!");
                    p.sendMessage(ChatColor.RED + "Invalid arguments");
                }
            }

        } else {
            Utils.logInfo(ChatColor.GOLD + "Failed to kick as sender is not a player!");
            Bukkit.getLogger().warning(ChatColor.GOLD + "Only players can run this command.");
        }
        return true;
    }
}
