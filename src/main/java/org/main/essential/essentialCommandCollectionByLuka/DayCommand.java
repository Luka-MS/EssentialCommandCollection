package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DayCommand implements CommandExecutor {

    private static final String PREFIX = "§7[§eZeit§7] §r";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("time.day")) {
            sender.sendMessage(PREFIX + "§cKeine Berechtigung die Zeit zu ändern!");
            return true;
        }

        for (World world : Bukkit.getWorlds()){
            world.setTime(1000);
        }
        sender.sendMessage(PREFIX + "Die Zeit wurde auf Tag gesetzt.");
        return true;
    }
}
