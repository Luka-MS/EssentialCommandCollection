package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen.");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("essentials.gm")) {
            player.sendMessage("§cKeine Berechtigung!");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage("§cBenutzung: /gm <0|1|2|3>");
            return true;
        }

        switch (args[0]) {
            case "0": player.setGameMode(GameMode.SURVIVAL); break;
            case "1": player.setGameMode(GameMode.CREATIVE); break;
            case "2": player.setGameMode(GameMode.ADVENTURE); break;
            case "3": player.setGameMode(GameMode.SPECTATOR); break;
            default:
                player.sendMessage("§cUngültiger Modus. Nutze: 0, 1, 2 oder 3");
                return true;
        }

        player.sendMessage("§aGamemode geändert zu §e" + player.getGameMode().name());
        return true;
    }
}
