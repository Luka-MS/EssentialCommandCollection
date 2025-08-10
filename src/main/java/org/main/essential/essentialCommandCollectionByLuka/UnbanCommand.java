package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnbanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("essentials.unban")) {
            sender.sendMessage("§cKeine Berechtigung!");
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage("§cBenutzung: /unban <Spieler>");
            return true;
        }

        String playerName = args[0];
        Bukkit.getBanList(org.bukkit.BanList.Type.NAME).pardon(playerName);
        sender.sendMessage("§a" + playerName + " wurde entbannt.");
        return true;
    }
}
