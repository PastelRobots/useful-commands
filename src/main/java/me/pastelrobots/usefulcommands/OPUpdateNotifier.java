package me.pastelrobots.usefulcommands;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class OPUpdateNotifier extends UpdateListener implements Listener {
    public OPUpdateNotifier(JavaPlugin plugin, int rsid) {
        super(plugin, rsid);
    }

    public void onOPJoinEvent(PlayerJoinEvent event) {
        if(event.getPlayer().isOp()) {
            event.getPlayer().sendMessage(ChatColor.GOLD + "You are using an old version of UsefulCommands! Get the new version here: " + ChatColor.BLUE + "https://www.spigotmc.org/resources/useful-commands.95341/\n" + ChatColor.ITALIC + "Only OPs receive this message");
        }
    }
}
