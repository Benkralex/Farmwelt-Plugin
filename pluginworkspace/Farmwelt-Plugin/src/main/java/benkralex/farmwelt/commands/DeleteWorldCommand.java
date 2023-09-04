package benkralex.farmwelt.commands;

import benkralex.farmwelt.worldmanager.CreateWorld;
import benkralex.farmwelt.worldmanager.DeleteWorld;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DeleteWorldCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("farm.delete")) {
                if (args.length >= 1) {
                    DeleteWorld.deleteWorld((args[0]));
                } else {
                    p.sendMessage("Usage: /deletefarmworld <Weltname>");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Du hast keine Berechtigung dazu");
            }
        }else {
            sender.sendMessage("Nur Spieler können diesen Command ausführen");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        ArrayList<String> list = new ArrayList<>();
        if (args.length == 1) {
            for (World world : Bukkit.getWorlds()) {
                list.add(world.getName());
            }
        }else {
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
