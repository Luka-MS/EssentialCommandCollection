package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DelWarpCommand implements CommandExecutor {

    private final WarpManager warpManager;
    private static final String PREFIX = "§7[§aWarp§7] §r";

    public DelWarpCommand(WarpManager warpManager) {
        this.warpManager = warpManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("warp.delete")) {
            sender.sendMessage(PREFIX + "Keine Berechtigung.");
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(PREFIX + "§cBenutzung: /delwarp <Name>");
            return true;
        }

        String name = args[0].toLowerCase();
        if (warpManager.getWarp(name) == null) {
            sender.sendMessage(PREFIX + "Warp §e" + name + " §cwurde nicht gefunden.");
            return true;
        }

        warpManager.deleteWarp(name);
        sender.sendMessage(PREFIX + "Warp §e" + name + " §cwurde gelöscht.");
        return true;
    }
}
