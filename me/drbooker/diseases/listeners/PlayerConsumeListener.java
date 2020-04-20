package me.drbooker.diseases.listeners;

import me.drbooker.diseases.utils.UserUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class PlayerConsumeListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void consumeEvent(PlayerItemConsumeEvent e) {
        Player p = e.getPlayer();
        if(!(e.getItem().getType() == Material.MILK_BUCKET)) return;
        if(UserUtils.getDiseases(p).isEmpty()) return;
        e.setCancelled(true);
    }
}
