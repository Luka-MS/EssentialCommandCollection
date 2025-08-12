package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InventorySeeCommand implements CommandExecutor {

    private static final String PREFIX = "§7[§eInvsee§7] §r";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(PREFIX + "Nur Spieler können diesen Befehl nutzen.");
            return true;
        }
        if (args.length != 1) {
            sender.sendMessage(PREFIX + "Benutzung: /invsee <Spieler>");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("invsee.use")) {
            player.sendMessage(PREFIX + "Keine Berechtigung.");
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            player.sendMessage(PREFIX + "Spieler nicht gefunden.");
            return true;
        }

        player.openInventory(target.getInventory());
        player.sendMessage(PREFIX + "Inventar von " + target.getName() + " geöffnet.");
        return true;
    }
}
