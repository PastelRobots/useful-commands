package me.pastelrobots.usefulcommands.tabcomplete;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NullTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> l = Collections.emptyList();
        if(command.getName().equalsIgnoreCase("brew") || command.getName().equalsIgnoreCase("craft") || command.getName().equalsIgnoreCase("discord") || command.getName().equalsIgnoreCase("disposal") || command.getName().equalsIgnoreCase("enchant") || command.getName().equalsIgnoreCase("enderchest") || command.getName().equalsIgnoreCase("furnace") || command.getName().equalsIgnoreCase("info") || command.getName().equalsIgnoreCase("memory") || command.getName().equalsIgnoreCase("motd") || command.getName().equalsIgnoreCase("reload") || command.getName().equalsIgnoreCase("rules") || command.getName().equalsIgnoreCase("stonecutter") || command.getName().equalsIgnoreCase("twitter") || command.getName().equalsIgnoreCase("ping")) {
            return l;
        }
        return null;
    }
}
