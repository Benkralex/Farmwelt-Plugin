package benkralex.farmwelt;

import benkralex.farmwelt.commands.CreateWorldCommand;
import benkralex.farmwelt.commands.DeleteWorldCommand;
import benkralex.farmwelt.commands.TpWorldCommand;
import benkralex.farmwelt.config.Config;
import org.bukkit.plugin.java.JavaPlugin;

public final class Farmwelt extends JavaPlugin {

    public static Farmwelt plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        Config.createConfig();
        getCommand("createfarmworld").setExecutor(new CreateWorldCommand());
        getCommand("farmworld").setExecutor(new TpWorldCommand());
        getCommand("deletefarmworld").setExecutor(new DeleteWorldCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public void onLoad() {
        // Plugin load logic
        plugin = this;
    }
}
