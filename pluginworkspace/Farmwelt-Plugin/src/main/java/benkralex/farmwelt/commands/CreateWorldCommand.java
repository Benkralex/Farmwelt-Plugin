package benkralex.farmwelt.commands;

import benkralex.farmwelt.worldmanager.CreateWorld;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateWorldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("farmwelt.create")) {
                if (args.length >= 2) {
                    String worldname = args[0];
                    World.Environment worldgenerator;
                    if (args[1].equalsIgnoreCase("overworld")) {
                        worldgenerator = CreateWorld.OVERWORLD;
                    } else if (args[1].equalsIgnoreCase("nether")) {
                        worldgenerator = CreateWorld.NETHER;
                    } else if (args[1].equalsIgnoreCase("end")) {
                        worldgenerator = CreateWorld.END;
                    } else {
                        p.sendMessage("Unbekannter Welttyp");
                        p.sendMessage("Welttypen: overworld / end / nether");
                        return true;
                    }
                    if ("false".equalsIgnoreCase(args[2])) {
                        CreateWorld.createWorld(worldname, worldgenerator, true, p);
                    } else {
                        CreateWorld.createWorld(worldname, worldgenerator, false, p);
                    }
                } else {
                    p.sendMessage("Usage: /createworld <Weltname> <Dimension> [true/false: private world]");
                }
            } else {p.sendMessage(ChatColor.RED + "Du hast keine Berechtigung dazu");}
        }else {
            commandSender.sendMessage("Nur Spieler können diesen Command ausführen");
        }
        return true;
    }
}
