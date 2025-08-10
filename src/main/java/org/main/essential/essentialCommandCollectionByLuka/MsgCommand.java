package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MsgCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen.");
            return true;
        }

        if (args.length < 2) {
            sender.sendMessage("§cBenutzung: /msg <spieler> <nachricht>");
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);
        if (target == null) {
            sender.sendMessage("§cSpieler nicht gefunden.");
            return true;
        }

        String message = String.join(" ", args).substring(args[0].length()).trim();

        target.sendMessage("§6[Privat] §e" + sender.getName() + "§7: §f" + message);
        sender.sendMessage("§6[Privat] §eAn " + target.getName() + "§7: §f" + message);
        return true;
    }
}
