package me.drbooker.diseases.listeners;

import me.drbooker.diseases.data.DataManager;
import me.drbooker.diseases.utils.StringUtils;
import me.drbooker.diseases.utils.UserUtils;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerDamageByEntityListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void zombieHitPlayer(EntityDamageByEntityEvent e) {
        if(!(e.getEntity() instanceof Player)) return;
        if(!(e.getDamager() instanceof Zombie)) return;
        Player p = (Player) e.getEntity();
        if(UserUtils.getDiseases(p).contains("zombieInfect")) return;
        if(DataManager.getInst().calculateChance(DataManager.getInst().zombieInfect)) {
            p.sendTitle(StringUtils.color("&6&lJestes zarazony!"), StringUtils.color("&7Uzyj jak najszybciej antybiotykow!"), 10, 40, 10);
            p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, Integer.MAX_VALUE, 0, false, false));
            p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 1, false, false));
            UserUtils.addDisease(p, "zombieInfect");
        }
    }
}
