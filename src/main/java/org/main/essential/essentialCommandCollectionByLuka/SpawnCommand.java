package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.main.essential.Main;

public class SpawnCommand implements CommandExecutor {

    private final Main plugin;

    public SpawnCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen.");
            return true;
        }

        Player player = (Player) sender;
        Location spawn = player.getWorld().getSpawnLocation();
        player.teleport(spawn);
        player.sendMessage("§aDu wurdest zum Spawn teleportiert!");
        return true;
    }
}
