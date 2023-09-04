package benkralex.farmwelt;

import benkralex.farmwelt.commands.CreateWorldCommand;
import benkralex.farmwelt.commands.DeleteWorldCommand;
import benkralex.farmwelt.commands.GoBackCommand;
import benkralex.farmwelt.commands.TpWorldCommand;
import benkralex.farmwelt.config.Config;
import benkralex.farmwelt.listeners.ListenerWorldChange;
import org.bukkit.Bukkit;
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
        getCommand("mainworld").setExecutor(new GoBackCommand());
        Bukkit.getPluginManager().registerEvents(new ListenerWorldChange(), this);
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
