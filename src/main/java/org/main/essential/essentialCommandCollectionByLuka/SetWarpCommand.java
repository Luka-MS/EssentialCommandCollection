package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarpCommand implements CommandExecutor {

    private final WarpManager warpManager;
    private static final String PREFIX = "§7[§aWarp§7] §r";

    public SetWarpCommand(WarpManager warpManager) {
        this.warpManager = warpManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(PREFIX + "Nur Spieler können Warps setzen.");
            return true;
        }
        Player player = (Player) sender;

        if (!player.hasPermission("warp.set")) {
            player.sendMessage(PREFIX + "Keine Berechtigung.");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(PREFIX + "§cBenutzung: /setwarp <Name>");
            return true;
        }

        String name = args[0].toLowerCase();
        warpManager.setWarp(name, player.getLocation());
        player.sendMessage(PREFIX + "Warp §e" + name + " §agesetzt.");
        return true;
    }
}
