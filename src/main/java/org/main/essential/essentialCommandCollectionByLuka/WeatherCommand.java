package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherCommand implements CommandExecutor {

    private static final String PREFIX = "§7[§bWeather§7] §r";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage(PREFIX + "Bitte nutze: /weather <clear|rain|thunder>");
            return true;
        }

        String weatherType = args[0].toLowerCase();
        World world;

        if (sender instanceof Player) {
            world = ((Player) sender).getWorld();
        } else {
            world = Bukkit.getWorlds().get(0);
        }

        switch (weatherType) {
            case "clear":
                world.setStorm(false);
                world.setThundering(false);
                sender.sendMessage(PREFIX + "Wetter auf klar gesetzt.");
                break;
            case "rain":
                world.setStorm(true);
                world.setThundering(false);
                sender.sendMessage(PREFIX + "Wetter auf Regen gesetzt.");
                break;
            case "thunder":
                world.setStorm(true);
                world.setThundering(true);
                sender.sendMessage(PREFIX + "Wetter auf Gewitter gesetzt.");
                break;
            default:
                sender.sendMessage(PREFIX + "Unbekannter Wettertyp. Nutze: clear, rain oder thunder.");
                break;
        }
        return true;
    }
}
