package org.main.essential.essentialCommandCollectionByLuka;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MuteListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String playerName = event.getPlayer().getName();

        if (MuteCommand.isMuted(playerName)) {
            event.getPlayer().sendMessage("§cDu bist gemutet und kannst nicht schreiben.");
            event.setCancelled(true);
        }
    }
}
