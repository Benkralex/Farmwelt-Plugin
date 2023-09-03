package benkralex.farmwelt.worldmanager;

import benkralex.farmwelt.Farmwelt;
import benkralex.farmwelt.config.Config;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CreateWorld {
    public static final World.Environment OVERWORLD = World.Environment.NORMAL;
    public static final World.Environment NETHER  = World.Environment.NETHER;
    public static final World.Environment END = World.Environment.THE_END;

    public static void createWorld(String name, World.Environment generation, boolean publicworld, Player p) {
        if (Bukkit.getWorld(name) != null) {
            p.sendMessage(ChatColor.RED + "Welt mit diesem Namen existiert bereits");
            return;
        }
        name.replace(":", "");
        name.replace(" ", "");
        WorldCreator creator = new WorldCreator(name);
        creator.environment(generation);
        if (!publicworld) {
            PersistentDataContainer pdc = p.getPersistentDataContainer();
            NamespacedKey worlds = new NamespacedKey(Farmwelt.plugin, "worlds");
            PersistentDataContainer pdcworlds = pdc.getOrDefault(worlds, PersistentDataType.TAG_CONTAINER, pdc.getAdapterContext().newPersistentDataContainer());
            pdcworlds.set(new NamespacedKey(Farmwelt.plugin, name), PersistentDataType.TAG_CONTAINER, pdcworlds.getAdapterContext().newPersistentDataContainer());
            World w = Bukkit.createWorld(creator);
            p.teleport(w.getSpawnLocation());
        } else {
            Config.createDefault(name, "true");
        }
    }
}
