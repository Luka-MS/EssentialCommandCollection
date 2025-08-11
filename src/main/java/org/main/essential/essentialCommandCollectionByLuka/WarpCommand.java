package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {

    private final WarpManager warpManager;
    private static final String PREFIX = "§7[§aWarp§7] §r";

    public WarpCommand(WarpManager warpManager) {
        this.warpManager = warpManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(PREFIX + "Nur Spieler können Warps nutzen.");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("warp.use")) {
            player.sendMessage(PREFIX + "Keine Berechtigung.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(PREFIX + "§cBenutzung: /warp <Name>");
            return true;
        }

        String name = args[0].toLowerCase();
        Location loc = warpManager.getWarp(name);

        if (loc == null) {
            player.sendMessage(PREFIX + "Warp §e" + name + " §cwurde nicht gefunden.");
            return true;
        }

        player.teleport(loc);
        player.sendMessage(PREFIX + "Du wurdest zu Warp §e" + name + " §ateleportiert.");
        return true;
    }
}
