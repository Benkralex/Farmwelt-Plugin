package benkralex.farmwelt.listeners;

import benkralex.farmwelt.Farmwelt;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class ListenerWorldChange implements Listener {
    public static void onWorldChange(PlayerChangedWorldEvent e) {
        if (e.getFrom().getName().equals("world")) {
            Player p = e.getPlayer();
            PersistentDataContainer pdc = p.getPersistentDataContainer();
            if (!pdc.has(new NamespacedKey(Farmwelt.plugin, "lastoverworldlocation"), PersistentDataType.INTEGER_ARRAY)) {
                int[] xyz = new int[3];
                xyz[0] = p.getLocation().getBlockX();
                xyz[1] = p.getLocation().getBlockY();
                xyz[2] = p.getLocation().getBlockZ();
                pdc.set(new NamespacedKey(Farmwelt.plugin, "lastoverworldlocation"), PersistentDataType.INTEGER_ARRAY, xyz);
            }
        }
    }
}
