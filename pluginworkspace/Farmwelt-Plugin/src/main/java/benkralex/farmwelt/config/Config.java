package benkralex.farmwelt.config;

import benkralex.farmwelt.Farmwelt;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    private static final FileConfiguration config = Farmwelt.plugin.getConfig();

    public static void createConfig() {
        config.options().copyDefaults(true);
        config.addDefault("allow-randomteleport" , true);
        config.addDefault("overworldname", "world");
        Farmwelt.plugin.saveConfig();
    }

    public static boolean getAllowRtp() {
        return config.getBoolean("allow-randomteleport");
    }

    public static void setAllowRtp(boolean b) {
        config.addDefault("allow-randomteleport" , b);
        Farmwelt.plugin.saveConfig();
    }

    public static String getMainWorld() {
        return config.getString("overworldname");
    }
}
