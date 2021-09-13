package me.pastelrobots.usefulcommands.tabcomplete;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class KickTabComplete implements TabCompleter {
        @Override
        public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
            List<String> l = new ArrayList<>();
            if (command.getName().equalsIgnoreCase("kick")) {
                if (args.length == 1) {
                    Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                    Bukkit.getServer().getOnlinePlayers().toArray(players);
                    for (int i = 0; i < players.length; i++) {
                        l.add(players[i].getName());
                    }
                    return l;
                } else if(args.length == 2) {
                    l.add("Hacking");
                    l.add("Advertising");
                    l.add("Impersonation");
                    l.add("Toxicity");
                    l.add("Racism");
                    l.add("Glitching");
                    l.add("Duping");
                    l.add("Macros");
                    l.add("Scamming");
                    l.add("Duping");
                    return l;
                }
            }
            return null;
        }
    }
