package me.pastelrobots.usefulcommands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Console {
    public class LogConsole {
        public void severe(String msg) {
            Bukkit.getLogger().severe(ChatColor.RED + "[SEVERE] >> " + msg);
        }
        public void warn(String msg) {
            Bukkit.getLogger().warning(ChatColor.GOLD +  "[Warn] >> " + msg);
        }
        public void info(String msg) {
            Bukkit.getLogger().info(ChatColor.BLUE + "[Info] >> " + msg);
        }
    }
}
