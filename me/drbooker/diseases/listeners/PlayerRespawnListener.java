package me.drbooker.diseases.listeners;

import me.drbooker.diseases.utils.UserUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public void respawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        if(UserUtils.getDiseases(p).isEmpty()) return;
        if(UserUtils.getDiseases(p).contains("pigInfect")) Bukkit.getScheduler().cancelTask(PlayerHitPigListener.pigInfectTask);
        UserUtils.deleteDiseases(p);
    }
}