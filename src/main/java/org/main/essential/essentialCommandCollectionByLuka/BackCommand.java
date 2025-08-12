package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BackCommand implements CommandExecutor {

    private static final String PREFIX = "§7[§aBack§7] §r";
    private static final Map<UUID, Location> lastLocations = new HashMap<>();

    public static void setLastLocation(Player player, Location location) {
        lastLocations.put(player.getUniqueId(), location);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(PREFIX + "Nur Spieler können diesen Befehl nutzen.");
            return true;
        }
        Player player = (Player) sender;
        if (!player.hasPermission("back.use")) {
            player.sendMessage(PREFIX + "Keine Berechtigung.");
            return true;
        }

        Location lastLoc = lastLocations.get(player.getUniqueId());
        if (lastLoc == null) {
            player.sendMessage(PREFIX + "Keine letzte Position gespeichert.");
            return true;
        }

        player.teleport(lastLoc);
        player.sendMessage(PREFIX + "Du wurdest zu deiner letzten Position teleportiert.");
        return true;
    }
}

