package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class BackListener implements Listener {

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        if (event.getFrom() != null) {
            org.main.essential.essentialCommandCollectionByLuka.BackCommand.setLastLocation(player, event.getFrom());
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player.getLocation() != null) {
            org.main.essential.essentialCommandCollectionByLuka.BackCommand.setLastLocation(player, player.getLocation());
        }
    }
}

