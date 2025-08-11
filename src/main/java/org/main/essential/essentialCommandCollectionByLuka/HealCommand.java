package org.main.essential.essentialCommandCollectionByLuka;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.attribute.Attribute;
import org.bukkit.potion.PotionEffect;

public class HealCommand implements CommandExecutor {

    private static final String PREFIX = "§7[§aHeal§7] §r";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            if (!(sender instanceof Player)) {
                sender.sendMessage(PREFIX + "Nur Spieler können diesen Befehl ohne Argument nutzen.");
                return true;
            }

            Player player = (Player) sender;
            if (!player.hasPermission("heal.use")) {
                player.sendMessage(PREFIX + "Du hast keine Berechtigung dazu.");
                return true;
            }

            heal(player);
            player.sendMessage(PREFIX + "Du wurdest geheilt.");
            return true;
        }

        if (!sender.hasPermission("heal.others")) {
            sender.sendMessage(PREFIX + "Du hast keine Berechtigung, andere zu heilen.");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null || !target.isOnline()) {
            sender.sendMessage(PREFIX + "Spieler '" + args[0] + "' nicht gefunden.");
            return true;
        }

        heal(target);
        sender.sendMessage(PREFIX + target.getName() + " wurde geheilt.");
        target.sendMessage(PREFIX + "Du wurdest geheilt.");

        return true;
    }

    private void heal(Player p) {
        double maxHealth = p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
        p.setHealth(maxHealth);
        p.setFoodLevel(20);
        p.setSaturation(20f);
        p.setFireTicks(0);
        p.setRemainingAir(p.getMaximumAir());
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
    }
}