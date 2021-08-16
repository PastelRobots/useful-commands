package me.pastelrobots.usefulcommands;

import me.pastelrobots.usefulcommands.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public final class UsefulCommands extends JavaPlugin {

    private File customConfigFile;
    private FileConfiguration customConfig;
    public static Plugin plugin;
    private Set<String> commands = this.getDescription().getCommands().keySet();


    @Override
    public void onEnable() {
        createCustomConfig();
        plugin = this;
        Utils.logInfo("Debug mode is enabled!");
        new UpdateListener(this, 95341).getVer(version -> {
            if(this.getDescription().getVersion().equalsIgnoreCase(version)) {
                Utils.logInfo(ChatColor.BLUE + "UpdateListener found no updates!");
            } else {
                this.getLogger().warning(ChatColor.GOLD + "You are using an old version of UsefulCommands! Get the new version here: " + ChatColor.BLUE + "https://www.spigotmc.org/resources/useful-commands.95341/");
            }
        });
        for (String c : this.commands) {
            Utils.logInfo("Registering the "+c+" command.");
            System.out.println(c);
            switch (c) {
                case "fly": {
                    getCommand(c).setExecutor(new FlyCommand());
                    break;
                }
                case "heal": {
                    getCommand(c).setExecutor(new HealCommand());
                    break;
                }
                case "configreload": {
                    getCommand(c).setExecutor(new ReloadCommand());
                    break;
                }
                case "clearinventory": {
                    getCommand(c).setExecutor(new ClearInventoryCommand());
                    break;
                }
                case "kick": {
                    getCommand(c).setExecutor(new KickCommand());
                    break;
                }
                case "enderchest": {
                    getCommand(c).setExecutor(new EnderchestCommand());
                    break;
                }
                case "xp": {
                    getCommand(c).setExecutor(new CheckXPCommand());
                    break;
                }
                case "god": {
                    getCommand(c).setExecutor(new GodCommand());
                    break;
                }
                case "feed": {
                    getCommand(c).setExecutor(new FeedCommand());
                    break;
                }
                case "smite": {
                    getCommand(c).setExecutor(new SmiteCommand());
                    break;
                }
                case "rules": {
                    getCommand(c).setExecutor(new RulesCommand());
                    break;
                }
                case "craft": {
                    getCommand(c).setExecutor(new CraftingTableCommand());
                    break;
                }
                case "memory": {
                    getCommand(c).setExecutor(new MemoryCommand());
                    break;
                }
                case "ping": {
                    getCommand(c).setExecutor(new PingCommand());
                    break;
                }
                case "weather": {
                    getCommand(c).setExecutor(new WeatherCommand());
                    break;
                }
                case "time": {
                    getCommand(c).setExecutor(new TimeCommand());
                    break;
                }
            }
        }

        if (plugin.getConfig().getBoolean("console.enabled-msg")) {
            Bukkit.getLogger().info(ChatColor.GOLD + "=============================================");
            Bukkit.getLogger().info(ChatColor.GREEN + "UsefulCommands has been turned on!");
            Bukkit.getLogger().info(ChatColor.GREEN + "If you need help or support join the" + ChatColor.BLUE + " discord.");
            Utils.logInfo("discord.gg/VtgcZRnmMR");
            Bukkit.getLogger().info(ChatColor.GOLD + "=============================================");
        }
        if (getServer().getPluginManager().getPlugin("LuckPerms") == null) {
            if (getServer().getPluginManager().getPlugin("PermissionsX") == null) {
                Bukkit.getLogger().info(ChatColor.RED + "Hello! if you are seeing this you're not in danger, it's just that you don't have LuckPerms or PermissionsX installed! These are recommended as this plugin contains permission editors to use commands. Any other permissions plugin is fine and this plugin will run fine without any.");
            }
        }
    }

    public void onDisable() {
        if (plugin.getConfig().getBoolean("console.enabled-msg")) {
            Bukkit.getLogger().info(ChatColor.RED + "=============================================");
            Utils.logInfo("UsefulCommands has been turned off!");
            Utils.logInfo("If you need help or support join the" + ChatColor.BLUE + " discord.");
            Bukkit.getLogger().info(ChatColor.DARK_BLUE + "discord.gg/VtgcZRnmMR");
            Utils.logInfo("Bye-bye!");
            Bukkit.getLogger().info(ChatColor.RED + "=============================================");
        }
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    private void createCustomConfig() {
        customConfigFile = new File(getDataFolder(), "config.yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            saveResource("config.yml", false);
        }

        customConfig= new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
