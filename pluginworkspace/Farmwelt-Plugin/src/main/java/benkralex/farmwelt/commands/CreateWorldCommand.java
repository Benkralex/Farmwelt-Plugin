package benkralex.farmwelt.commands;

import benkralex.farmwelt.worldmanager.CreateWorld;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CreateWorldCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            if (p.hasPermission("farm.create")) {
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
                        p.sendMessage("Welttypen: Overworld / Nether / End");
                        return true;
                    }
                    if (!(args.length >= 3)) {
                        CreateWorld.createWorld(worldname, worldgenerator, true, p);
                    }
                    CreateWorld.createWorld(worldname, worldgenerator, "false".equalsIgnoreCase(args[2]), p);
                    p.sendMessage(ChatColor.GREEN + "Welt wurde erstellt");
                } else {
                    p.sendMessage("Usage: /createfarmworld <Weltname> <Dimension> [true/false: private world]");
                }
            } else {p.sendMessage(ChatColor.RED + "Du hast keine Berechtigung dazu");}
        }else {
            commandSender.sendMessage("Nur Spieler können diesen Command ausführen");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 1) {
            return list;
        } else if (args.length == 2) {
            list.add("Overworld");
            list.add("Nether");
            list.add("End");
        } else if (args.length == 3) {
            list.add("true");
            list.add("false");
        } else {
            return list;
        }
        ArrayList<String> tabcompleter = new ArrayList<>();
        String curentarg = args[args.length - 1].toLowerCase();
        for (String s : list) {
            String s1 = s.toLowerCase();
            if (s1.startsWith(curentarg)) {
                tabcompleter.add(s);
            }
        }
        return tabcompleter;
    }
}
