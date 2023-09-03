package benkralex.farmwelt.commands;

import benkralex.farmwelt.worldmanager.TpWorld;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpWorldCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("farmwelt.tp")) {
                if (args.length >= 1) {
                    TpWorld.tpWorld(p, Bukkit.getWorld(args[0]));
                } else {
                    p.sendMessage("Usage: /farmwelttp <Weltname>");
                }
            }
        } else {
            sender.sendMessage("Nur Spieler können diesen Command ausführen");
        }
        return true;
    }
}
