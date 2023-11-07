package benkralex.farmwelt.worldmanager;

import benkralex.farmwelt.Farmwelt;
import benkralex.farmwelt.config.Config;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class TpWorld {
    public static void tpWorld(Player p, World w) {
        String name = w.getName();
        PersistentDataContainer pdc = p.getPersistentDataContainer();
        int[] xyz = new int[3];
        xyz[0] = p.getLocation().getX();
        xyz[1] = p.getLocation().getY();
        xyz[2] = p.getLocation().getZ();
        pdc.set(new NamespacedKey(Farmwelt.plugin, "lastmainworldloc"), PersistentDataType.INTEGER_ARRAY, xyz);
        p.teleport(w.getSpawnLocation());
    }

    public static void tpOverworld(Player p, World w) {
        PersistentDataContainer pdc = p.getPersistentDataContainer();
        if (!pdc.has(new NamespacedKey(Farmwelt.plugin, "lastoverworldlocation"), PersistentDataType.INTEGER_ARRAY)) {
            int[] xyz = new int[3];
            xyz[0] = w.getSpawnLocation().getBlockX();
            xyz[1] = w.getSpawnLocation().getBlockY();
            xyz[2] = w.getSpawnLocation().getBlockZ();
            pdc.set(new NamespacedKey(Farmwelt.plugin, "lastmainworldloc"), PersistentDataType.INTEGER_ARRAY, xyz);
        }
        int[] lastmainworldloc = pdc.get(new NamespacedKey(Farmwelt.plugin, "lastoverworldlocation"), PersistentDataType.INTEGER_ARRAY);
        Location teleportlocation = new Location(w, lastoverworldlocations[0],lastoverworldlocations[1], lastoverworldlocations[2]);
        p.teleport(teleportlocation);
    }
}
