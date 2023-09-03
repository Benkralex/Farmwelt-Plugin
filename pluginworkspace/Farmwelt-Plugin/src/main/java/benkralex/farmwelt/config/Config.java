package benkralex.farmwelt.config;

import benkralex.farmwelt.Farmwelt;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    private static final FileConfiguration config = Farmwelt.plugin.getConfig();

    public static void createConfig() {
        config.options().copyDefaults(true);
        //config.addDefault("" , );
        Farmwelt.plugin.saveConfig();
    }

    public static void createDefault(String defaultname, String value) {
        config.options().copyDefaults(true);
        config.addDefault(defaultname, value);
        Farmwelt.plugin.saveConfig();
    }

    public static String getDefault(String defaultname) {
        return config.getString(defaultname);
    }
}
