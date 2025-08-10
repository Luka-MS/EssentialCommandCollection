package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("essentials.kill")) {
            sender.sendMessage("§cKeine Berechtigung!");
            return true;
        }

        Player target;

        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("§cBitte gib einen Spielernamen an.");
                return true;
            }
            target = (Player) sender;
        } else {
            target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                sender.sendMessage("§cSpieler nicht gefunden.");
                return true;
            }
        }

        target.setHealth(0);
        sender.sendMessage("§a" + target.getName() + " wurde getötet.");
        return true;
    }
}
