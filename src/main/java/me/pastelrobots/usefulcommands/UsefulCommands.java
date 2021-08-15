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

public final class UsefulCommands extends JavaPlugin {

    private File customConfigFile;
    private FileConfiguration customConfig;
    public static Plugin plugin;

    @Override
    public void onEnable() {
        createCustomConfig();
            plugin = this;
            if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
                Bukkit.getLogger().info(ChatColor.WHITE + "Debug mode is enabled!");
            }
        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering fly command");
        }
            getCommand("fly").setExecutor(new FlyCommand());
        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering heal command");
        }
            getCommand("heal").setExecutor(new HealCommand());
        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering reload command");
        }
            getCommand("configreload").setExecutor(new ReloadCommand());
        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering clearinventory command");
        }
        getCommand("clearinventory").setExecutor(new ClearInventoryCommand());
        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering kick command");
        }
        getCommand("kick").setExecutor(new KickCommand());
        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering enderchest command");
        }
        getCommand("enderchest").setExecutor(new EnderchestCommand());

        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering xp command");
        }
        getCommand("xp").setExecutor(new CheckXPCommand());

        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering god command");
        }
        getCommand("god").setExecutor(new GodCommand());
        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering feed command");
        }
        getCommand("feed").setExecutor(new GodCommand());

        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering smite command");
        }
        getCommand("smite").setExecutor(new SmiteCommand());

        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering rules command");
        }
        getCommand("rules").setExecutor(new RulesCommand());

        if (plugin.getConfig().getBoolean("console.debug-mode") == true) {
            Bukkit.getLogger().info(ChatColor.BLUE + "Registering craft command");
        }
        getCommand("craft").setExecutor(new CraftingTableCommand());
            if (plugin.getConfig().getBoolean("console.enabled-msg")) {
                Bukkit.getLogger().info(ChatColor.GOLD + "=============================================");
                Bukkit.getLogger().info(ChatColor.GREEN + "UsefulCommands has been turned on!");
                Bukkit.getLogger().info(ChatColor.GREEN + "If you need help or support join the" + ChatColor.BLUE + " discord.");
                Bukkit.getLogger().info(ChatColor.BLUE + "discord.gg/VtgcZRnmMR");
                Bukkit.getLogger().info(ChatColor.GOLD + "=============================================");
            }
            if (getServer().getPluginManager().getPlugin("LuckPerms") != null) {
                if (getServer().getPluginManager().getPlugin("PermissionsX") != null) {
                    Bukkit.getLogger().info(ChatColor.RED + "Hello! You are seeing this you're not in danger, it's just because you don't have LuckPerms or PermissionsX installed! These are recommended as this plugin contains permissions to use commands. Any other permissions plugin is fine and this plugin will run fine without any of these.");
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
