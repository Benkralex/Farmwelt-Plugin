package benkralex.farmwelt.commands;

import benkralex.farmwelt.worldmanager.TpWorld;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GoBackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("farm.tp")) {
                TpWorld.tpOverworld(p, Bukkit.getWorld(args[0]));
            } else {
                p.sendMessage("Usage: /mainworld");
            }
        } else {
            sender.sendMessage("Nur Spieler können diesen Command ausführen");
        }
        return true;
    }
}
