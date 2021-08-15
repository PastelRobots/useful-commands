package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().info(ChatColor.BLUE + "Checking args");
            }
            if(args.length < 1) {
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                }
                if(p.hasPermission("usefulcommands.spawn")) {
                    Location loc = p.getWorld().getSpawnLocation();
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.BLUE + "Teleporting player");
                    }
                    p.teleport(loc);
                    if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                        Bukkit.getLogger().info(ChatColor.GREEN + "Success: Player was sent to spawn!");
                    }
                    p.sendMessage(ChatColor.GREEN + "Teleported to spawn!");
                }
            } else {
                if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                    Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                }
                if(p.hasPermission("usefulcommands.spawn.others")) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        Location loc = target.getWorld().getSpawnLocation();
                        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                            Bukkit.getLogger().info(ChatColor.BLUE + "Checking perms");
                        }
                        target.teleport(loc);
                        if (UsefulCommands.plugin.getConfig().getBoolean("console.debug-mode") == true) {
                            Bukkit.getLogger().info(ChatColor.GREEN + "Success: Target was sent to spawn!");
                        }
                        target.sendMessage(ChatColor.RED + "You were sent to spawn!");
                        p.sendMessage(ChatColor.GREEN + "You have sent " + ChatColor.UNDERLINE + target.getName() + ChatColor.GREEN + " to spawn!");
                    }
                }
            }
        } else {

        }



        return true;
    }
}
