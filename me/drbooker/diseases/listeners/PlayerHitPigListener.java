package me.drbooker.diseases.listeners;

import me.drbooker.diseases.Diseases;
import me.drbooker.diseases.data.DataManager;
import me.drbooker.diseases.utils.StringUtils;
import me.drbooker.diseases.utils.UserUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerHitPigListener implements Listener {

    public static int pigInfectTask;
    //TODO WYPROBOROWAC HASHMAPE DO TEGO BO NIE DZIALA Z SAMYM INTEM USUWANIE
    @EventHandler
    public void onPigHit(EntityDamageByEntityEvent e) {
        if(!(e.getEntity() instanceof Pig)) return;
        if(!(e.getDamager() instanceof Player)) return;
        Player p = (Player) e.getDamager();
        if(UserUtils.getDiseases(p).contains("pigInfect")) return;
        if(DataManager.getInst().calculateChance(DataManager.getInst().pigInfect)) {
            p.sendTitle(StringUtils.color("&6&lSwinska grypa!"), StringUtils.color("&7Uzyj inhibitorow neuraminidazy!"), 10, 70, 20);
            pigInfectTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(Diseases.getInst(), new Runnable() {
                @Override
                public void run() {
                    p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 3, false, false));
                    p.damage(4);
                }
            }, 0L, 15 * 20L);
            UserUtils.addDisease(p, "pigInfect");
        }
    }
}