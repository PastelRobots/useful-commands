package me.pastelrobots.usefulcommands;

import com.tchristofferson.configupdater.ConfigUpdater;
import me.pastelrobots.usefulcommands.commands.*;
import me.pastelrobots.usefulcommands.tabcomplete.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

public final class UsefulCommands extends JavaPlugin {

    public ArrayList<Player> invisible_list = new ArrayList<>();

    private File customConfigFile;
    private FileConfiguration customConfig;
    public static Plugin plugin;
    private Set<String> commands = this.getDescription().getCommands().keySet();


    @Override
    public void onEnable() {
        plugin = this;
        int pluginId = 12485;
        Metrics metrics = new Metrics(this, pluginId);
        createCustomConfig();
        saveDefaultConfig();
        File configFile = new File(getDataFolder(), "config.yml");

        try {
            ConfigUpdater.update(plugin, "config.yml", configFile, Collections.emptyList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        reloadConfig();
        Utils.logInfo("Debug mode is enabled!");
        new UpdateListener(this, 95341).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                Utils.logInfo(ChatColor.BLUE + "No update avaliable.");
            } else {
                Bukkit.getLogger().warning(ChatColor.GOLD + "Hey! You're using an old version of UsefulCommands. Grab the last version here:" + ChatColor.BLUE + "spigotmc.org/resources/useful-commands.95341/");
            }
        });

        for (String c : this.commands) {
            Utils.logInfo("Registering the "+c+" command.");
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
                    getCommand(c).setTabCompleter(new NullTabComplete());
                    break;
                }
                case "clearinventory": {
                    getCommand(c).setExecutor(new ClearInventoryCommand());
                    getCommand(c).setTabCompleter(new PlayerTabComplete());
                    break;
                }
                case "kick": {
                    getCommand(c).setExecutor(new KickCommand());
                    getCommand(c).setTabCompleter(new KickTabComplete());
                    break;
                }
                case "enderchest": {
                    getCommand(c).setExecutor(new EnderchestCommand());
                    getCommand(c).setTabCompleter(new NullTabComplete());
                    break;
                }
                case "xp": {
                    getCommand(c).setExecutor(new CheckXPCommand());
                    getCommand(c).setTabCompleter(new PlayerTabComplete());
                    break;
                }
                case "god": {
                    getCommand(c).setExecutor(new GodCommand());
                    getCommand(c).setTabCompleter(new PlayerTabComplete());
                    break;
                }
                case "feed": {
                    getCommand(c).setExecutor(new FeedCommand());
                    getCommand(c).setTabCompleter(new PlayerTabComplete());
                    break;
                }
                case "smite": {
                    getCommand(c).setExecutor(new SmiteCommand());
                    getCommand(c).setTabCompleter(new PlayerTabComplete());
                    break;
                }
                case "rules": {
                    getCommand(c).setExecutor(new RulesCommand());
                    getCommand(c).setTabCompleter(new NullTabComplete());
                    break;
                }
                case "craft": {
                    getCommand(c).setExecutor(new CraftingTableCommand());
                    getCommand(c).setTabCompleter(new NullTabComplete());
                    break;
                }
                case "memory": {
                    getCommand(c).setExecutor(new MemoryCommand());
                    getCommand(c).setTabCompleter(new NullTabComplete());
                    break;
                }
                case "ping": {
                    getCommand(c).setExecutor(new PingCommand());
                    getCommand(c).setTabCompleter(new NullTabComplete());
                    break;
                }
                case "enchanttable": {
                    getCommand(c).setExecutor(new EnchantTableCommand());
                    getCommand(c).setTabCompleter(new NullTabComplete());
                    break;
                }
                case "furnace": {
                    getCommand(c).setExecutor(new FurnaceCommand());
                    getCommand(c).setTabCompleter(new NullTabComplete());
                    break;
                }
                case "brew": {
                    getCommand(c).setExecutor(new BrewingCommand());
                    getCommand(c).setTabCompleter(new NullTabComplete());
                    break;
                }
                case "info": {
                    getCommand(c).setExecutor(new InfoCommand());
                    getCommand(c).setTabCompleter(new NullTabComplete());
                    break;
                }
                case "motd": {
                    getCommand(c).setExecutor(new MOTDCommand());
                    getCommand(c).setTabCompleter(new NullTabComplete());
                    break;
                }
                case "disposal": {
                    getCommand(c).setExecutor(new DisposalCommand());
                    getCommand(c).setTabCompleter(new NullTabComplete());
                }
            }
        }

        if (plugin.getConfig().getBoolean("console.enabled-msg")) {
            Bukkit.getLogger().info(ChatColor.GOLD + "=============================================");
            Bukkit.getLogger().info(ChatColor.GREEN + "UsefulCommands has been turned on!");
            Bukkit.getLogger().info(ChatColor.GREEN + "If you need help or support join the" + ChatColor.BLUE + " discord.");
            Bukkit.getLogger().info(ChatColor.BLUE +"discord.gg/VtgcZRnmMR");
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
            Bukkit.getLogger().info(ChatColor.BLUE + "UsefulCommands has been turned off!");
            Bukkit.getLogger().info(ChatColor.BLUE + "If you need help or support join the" + ChatColor.BLUE + " discord.");
            Bukkit.getLogger().info(ChatColor.DARK_BLUE + "discord.gg/VtgcZRnmMR");
            Bukkit.getLogger().info(ChatColor.BLUE + "Bye-bye!");
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
