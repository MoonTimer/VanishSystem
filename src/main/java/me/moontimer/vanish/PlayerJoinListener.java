package me.moontimer.vanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        for (Player vanish : Vanish.vanished) {
            if (!event.getPlayer().hasPermission("vanish.see")) {
                event.getPlayer().hidePlayer(vanish);
            }
        }
    }
}
