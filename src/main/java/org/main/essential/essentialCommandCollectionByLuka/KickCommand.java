package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("essentials.kick")) {
            sender.sendMessage("§cKeine Berechtigung!");
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage("§cBenutzung: /kick <spieler> [grund]");
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            sender.sendMessage("§cSpieler nicht gefunden.");
            return true;
        }

        String reason = (args.length > 1) ? String.join(" ", args).substring(args[0].length()).trim() : "Du wurdest gekickt!";
        target.kickPlayer(reason);
        sender.sendMessage("§aSpieler " + target.getName() + " wurde gekickt.");
        return true;
    }
}
