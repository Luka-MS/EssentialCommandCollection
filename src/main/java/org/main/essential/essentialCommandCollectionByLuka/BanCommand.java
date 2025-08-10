package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("essentials.ban")) {
            sender.sendMessage("§cKeine Berechtigung!");
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage("§cBenutzung: /ban <spieler> [grund]");
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);
        String reason = (args.length > 1) ? String.join(" ", args).substring(args[0].length()).trim() : "Du wurdest gebannt!";

        Bukkit.getBanList(org.bukkit.BanList.Type.NAME).addBan(args[0], reason, null, sender.getName());

        if (target != null) {
            target.kickPlayer(reason);
        }

        sender.sendMessage("§aSpieler " + args[0] + " wurde gebannt.");
        return true;
    }
}