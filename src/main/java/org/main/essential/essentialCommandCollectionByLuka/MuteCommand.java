package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class MuteCommand implements CommandExecutor {

    public static final Set<String> mutedPlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("essentials.mute")) {
            sender.sendMessage("§cKeine Berechtigung!");
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage("§cBenutzung: /mute <Spieler>");
            return true;
        }

        String targetName = args[0];
        Player target = Bukkit.getPlayerExact(targetName);

        if (target == null) {
            sender.sendMessage("§cSpieler nicht gefunden.");
            return true;
        }

        if (mutedPlayers.contains(targetName)) {
            mutedPlayers.remove(targetName);
            sender.sendMessage("§a" + targetName + " wurde entmutet.");
            target.sendMessage("§aDu wurdest entmutet.");
        } else {
            mutedPlayers.add(targetName);
            sender.sendMessage("§a" + targetName + " wurde gemutet.");
            target.sendMessage("§cDu wurdest gemutet.");
        }
        return true;
    }

    // Das Muting musst du noch im Chat-Listener checken, dass gemutete Spieler nichts schreiben können!
    public static boolean isMuted(String playerName) {
        return mutedPlayers.contains(playerName);
    }
}
