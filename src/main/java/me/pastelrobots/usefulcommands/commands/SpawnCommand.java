package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import me.pastelrobots.usefulcommands.Utils;
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
            Utils.logInfo(ChatColor.BLUE + "Checking args");
            if(args.length < 1) {
                Utils.logInfo(ChatColor.BLUE + "Checking perms");
                if(p.hasPermission("usefulcommands.spawn")) {
                    Utils.logInfo(ChatColor.BLUE + "Grabbing spawn coords");
                    Location loc = p.getWorld().getSpawnLocation();
                    Utils.logInfo(ChatColor.BLUE + "Teleporting player");
                    p.teleport(loc);
                    Utils.logInfo(ChatColor.BLUE + "Success: Player was sent to spawn!");
                    p.sendMessage(ChatColor.GREEN + "Teleported to spawn!");
                }
            } else {
                Utils.logInfo(ChatColor.BLUE + "Checking perms");
                if(p.hasPermission("usefulcommands.spawn.others")) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target instanceof Player) {
                        Utils.logInfo(ChatColor.BLUE + "Grabbing spawn coords");
                        Location loc = target.getWorld().getSpawnLocation();
                        Utils.logInfo(ChatColor.BLUE + "Teleporting player");
                        target.teleport(loc);
                        Utils.logInfo(ChatColor.BLUE + "Success: Target was sent to spawn!");
                        target.sendMessage(ChatColor.RED + "You were sent to spawn!");
                        p.sendMessage(ChatColor.GREEN + "You have sent " + ChatColor.UNDERLINE + target.getName() + ChatColor.GREEN + " to spawn!");
                    } else {

                    }
                }
            }
        } else {

        }



        return true;
    }
}
