package me.pastelrobots.usefulcommands.tabcomplete;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerTabComplete implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> l = new ArrayList<>();
        if (command.getName().equalsIgnoreCase("xp") || command.getName().equalsIgnoreCase("clearinventory") || command.getName().equalsIgnoreCase("feed") || command.getName().equalsIgnoreCase("fly") || command.getName().equalsIgnoreCase("god") || command.getName().equalsIgnoreCase("heal") || command.getName().equalsIgnoreCase("smite") || command.getName().equalsIgnoreCase("spawn")) {
            if (args.length == 1) {
                Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                Bukkit.getServer().getOnlinePlayers().toArray(players);
                for (int i = 0; i < players.length; i++) {
                    l.add(players[i].getName());
                }
                return l;
            }
        }
        return null;
    }
}
