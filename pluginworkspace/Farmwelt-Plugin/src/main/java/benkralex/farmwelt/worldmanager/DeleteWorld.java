package benkralex.farmwelt.worldmanager;

import benkralex.farmwelt.Farmwelt;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.File;

public class DeleteWorld {
    public static void deleteWorld(String name) {
        Bukkit.unloadWorld(name, false);
        File worldornder = new File(Bukkit.getWorldContainer(), name);
        worldornder.delete();
    }
}
