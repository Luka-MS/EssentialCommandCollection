package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TpaCommands implements CommandExecutor {

    private static final Map<Player, Player> tpaRequests = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen.");
            return true;
        }
        Player player = (Player) sender;
        String command = cmd.getName().toLowerCase();

        switch (command) {
            case "tpa":
                if (args.length < 1) {
                    player.sendMessage("§cBenutzung: /tpa <Spieler>");
                    return true;
                }
                Player target = Bukkit.getPlayerExact(args[0]);
                if (target == null) {
                    player.sendMessage("§cSpieler nicht gefunden.");
                    return true;
                }
                tpaRequests.put(target, player);
                target.sendMessage("§e" + player.getName() + " möchte sich zu dir teleportieren. Tippe /tpaccept oder /tpdeny.");
                player.sendMessage("§aTeleport-Anfrage gesendet.");
                return true;

            case "tpaccept":
                Player requester = tpaRequests.get(player);
                if (requester == null) {
                    player.sendMessage("§cKeine ausstehende Teleport-Anfrage.");
                    return true;
                }
                requester.teleport(player);
                requester.sendMessage("§aTeleport erfolgreich!");
                player.sendMessage("§aDu hast die Teleport-Anfrage angenommen.");
                tpaRequests.remove(player);
                return true;

            case "tpdeny":
                Player req = tpaRequests.get(player);
                if (req == null) {
                    player.sendMessage("§cKeine ausstehende Teleport-Anfrage.");
                    return true;
                }
                req.sendMessage("§cTeleport-Anfrage abgelehnt.");
                player.sendMessage("§aDu hast die Teleport-Anfrage abgelehnt.");
                tpaRequests.remove(player);
                return true;

            case "tpahere":
                if (args.length < 1) {
                    player.sendMessage("§cBenutzung: /tpahere <Spieler>");
                    return true;
                }
                Player toHere = Bukkit.getPlayerExact(args[0]);
                if (toHere == null) {
                    player.sendMessage("§cSpieler nicht gefunden.");
                    return true;
                }
                tpaRequests.put(toHere, player);
                toHere.sendMessage("§e" + player.getName() + " möchte dich zu sich teleportieren. Tippe /tpaccept oder /tpdeny.");
                player.sendMessage("§aTeleport-Anfrage gesendet.");
                return true;

            default:
                player.sendMessage("§cUnbekannter Befehl.");
                return true;
        }
    }
}
