package me.pastelrobots.usefulcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

public class UpdateListener extends JavaPlugin {
    private JavaPlugin plugin;
    private int rsid;

    public UpdateListener(JavaPlugin plugin, int rsid) {
        this.plugin = plugin;
        this.rsid = rsid;
    }

    public void getVer(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.rsid).openStream(); Scanner scanner = new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                Bukkit.getLogger().severe(ChatColor.RED + "Error: Cannot look for updates: " + exception);
            }
        });
    }
}
