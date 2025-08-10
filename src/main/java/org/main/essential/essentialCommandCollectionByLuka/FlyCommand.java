package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen.");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("essentials.fly")) {
            player.sendMessage("§cKeine Berechtigung!");
            return true;
        }

        boolean flying = player.getAllowFlight();
        player.setAllowFlight(!flying);
        player.sendMessage(flying ? "§cFlugmodus deaktiviert." : "§aFlugmodus aktiviert.");
        return true;
    }
}
