package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UnmuteCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("essentials.unmute")) {
            sender.sendMessage("§cKeine Berechtigung!");
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage("§cBenutzung: /unmute <Spieler>");
            return true;
        }

        String targetName = args[0];

        if (!MuteCommand.isMuted(targetName)) {
            sender.sendMessage("§cSpieler ist nicht gemutet.");
            return true;
        }

        // MuteCommand hat die Methode zum Entfernen
        MuteCommand.mutedPlayers.remove(targetName);
        sender.sendMessage("§a" + targetName + " wurde entmutet.");
        Player target = Bukkit.getPlayerExact(targetName);
        if (target != null) {
            target.sendMessage("§aDu wurdest entmutet.");
        }
        return true;
    }
}
