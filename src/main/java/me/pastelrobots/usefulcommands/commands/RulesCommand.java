package me.pastelrobots.usefulcommands.commands;

import me.pastelrobots.usefulcommands.UsefulCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RulesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        if(s instanceof Player) {
            Player p = (Player) s;
            if(UsefulCommands.plugin.getConfig().getBoolean("rules.enabled") == true) {
                p.sendMessage(UsefulCommands.plugin.getConfig().getString("rules.msg"));
            }
        }


        return true;
    }
}
