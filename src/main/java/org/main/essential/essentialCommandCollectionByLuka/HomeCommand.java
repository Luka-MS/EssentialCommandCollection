package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.main.essential.Main;

public class HomeCommand implements CommandExecutor {

    private final Main plugin;

    public HomeCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Nur Spieler können diesen Befehl nutzen.");
            return true;
        }

        Player player = (Player) sender;
        String path = "homes." + player.getUniqueId();

        if (!plugin.getConfig().contains(path)) {
            player.sendMessage("§cDu hast noch kein Home gesetzt!");
            return true;
        }

        World world = Bukkit.getWorld(plugin.getConfig().getString(path + ".world"));
        double x = plugin.getConfig().getDouble(path + ".x");
        double y = plugin.getConfig().getDouble(path + ".y");
        double z = plugin.getConfig().getDouble(path + ".z");
        float yaw = (float) plugin.getConfig().getDouble(path + ".yaw");
        float pitch = (float) plugin.getConfig().getDouble(path + ".pitch");

        player.teleport(new Location(world, x, y, z, yaw, pitch));
        player.sendMessage("§aWillkommen zu deinem Home!");
        return true;
    }
}
