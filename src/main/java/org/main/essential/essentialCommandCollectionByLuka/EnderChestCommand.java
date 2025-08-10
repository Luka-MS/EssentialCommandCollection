package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen.");
            return true;
        }

        Player player = (Player) sender;
        Player target = player;

        if (args.length > 0) {
            if (!player.hasPermission("essentials.enderchest.others")) {
                player.sendMessage("§cKeine Berechtigung, andere Enderchests zu öffnen!");
                return true;
            }
            target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                player.sendMessage("§cSpieler nicht gefunden.");
                return true;
            }
        }

        player.openInventory(target.getEnderChest());
        return true;
    }
}
