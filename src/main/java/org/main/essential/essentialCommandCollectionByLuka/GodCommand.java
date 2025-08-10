package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class GodCommand implements CommandExecutor {

    private final Set<Player> godPlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen.");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("essentials.god")) {
            player.sendMessage("§cKeine Berechtigung!");
            return true;
        }

        if (godPlayers.contains(player)) {
            godPlayers.remove(player);
            player.setInvulnerable(false);
            player.sendMessage("§cGodmodus deaktiviert.");
        } else {
            godPlayers.add(player);
            player.setInvulnerable(true);
            player.sendMessage("§aGodmodus aktiviert.");
        }

        return true;
    }
}
