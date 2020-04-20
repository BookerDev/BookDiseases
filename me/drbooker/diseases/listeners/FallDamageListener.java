package me.drbooker.diseases.listeners;

import me.drbooker.diseases.data.DataManager;
import me.drbooker.diseases.utils.StringUtils;
import me.drbooker.diseases.utils.UserUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FallDamageListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onFallDamage(final EntityDamageEvent e) {
        if(!(e.getEntity() instanceof Player)) return;
        Player p = (Player) e.getEntity();
        if(e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            if(UserUtils.getDiseases(p).contains("brokenLeg")) return;
            if(DataManager.getInst().calculateChance(DataManager.getInst().brokenLegChance)) {
                p.sendTitle(StringUtils.color("&6&lZlamales noge!"), StringUtils.color("&7Uzyj jak najszybciej bandaza!"), 10, 40, 10);
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 2, false, false));
                UserUtils.addDisease(p, "brokenLeg");
            }
        }
    }
}
