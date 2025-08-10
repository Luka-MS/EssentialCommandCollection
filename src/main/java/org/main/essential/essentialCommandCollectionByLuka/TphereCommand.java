package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TphereCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen.");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("essentials.tphere")) {
            player.sendMessage("§cKeine Berechtigung!");
            return true;
        }

        if (args.length < 1) {
            player.sendMessage("§cBenutzung: /tphere <Spieler>");
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            player.sendMessage("§cSpieler nicht gefunden.");
            return true;
        }

        target.teleport(player);
        player.sendMessage("§a" + target.getName() + " wurde zu dir teleportiert.");
        return true;
    }
}
