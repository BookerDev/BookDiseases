package me.drbooker.diseases.listeners;

import me.drbooker.diseases.utils.UserUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if(!UserUtils.checkFile(p)) UserUtils.initUser(p);

    }
}