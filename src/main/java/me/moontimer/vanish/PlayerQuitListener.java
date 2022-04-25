package me.moontimer.vanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        for (Player vanish : Vanish.vanished) {
            player.showPlayer(vanish);
        }

        if (Vanish.vanished.contains(player)) {
            Vanish.vanished.remove(player);
        }
    }
}
