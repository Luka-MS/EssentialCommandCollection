package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class NickCommand implements CommandExecutor {

    private static final Map<Player, String> nicknames = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen.");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("essentials.nick")) {
            player.sendMessage("§cKeine Berechtigung!");
            return true;
        }

        if (args.length == 0) {
            // Nick zurücksetzen
            player.setDisplayName(player.getName());
            player.setPlayerListName(player.getName());
            nicknames.remove(player);
            player.sendMessage("§aDein Nick wurde zurückgesetzt.");
            return true;
        }

        String nick = args[0];
        player.setDisplayName(nick);
        player.setPlayerListName(nick);
        nicknames.put(player, nick);
        player.sendMessage("§aDein Nick wurde gesetzt: " + nick);
        return true;
    }
}
