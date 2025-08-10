package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.main.essential.Main;

public class TeleportCommand implements CommandExecutor {

    private final Main plugin;

    public TeleportCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen.");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage("§cBenutzung: /tp <spieler>");
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);

        if (target == null) {
            player.sendMessage("§cSpieler nicht gefunden.");
            return true;
        }

        player.teleport(target);
        player.sendMessage("§aDu wurdest zu " + target.getName() + " teleportiert.");
        return true;
    }
}
