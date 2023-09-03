package benkralex.farmwelt.worldmanager;

import benkralex.farmwelt.Farmwelt;
import benkralex.farmwelt.config.Config;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class TpWorld {
    public static void tpWorld(Player p, World w) {
        String name = w.getName();
        PersistentDataContainer pdc = p.getPersistentDataContainer();
        if ("true".equals(Config.getDefault(name))) {
            p.teleport(w.getSpawnLocation());
        } else {
            if (pdc.has(new NamespacedKey(Farmwelt.plugin, "worlds"), PersistentDataType.TAG_CONTAINER)) {
                if (pdc.get(new NamespacedKey(Farmwelt.plugin, "worlds"), PersistentDataType.TAG_CONTAINER).has(new NamespacedKey(Farmwelt.plugin, name), PersistentDataType.TAG_CONTAINER)) {
                    p.teleport(w.getSpawnLocation());
                }
            }
        }
    }
}
