package me.drbooker.diseases.listeners;

import me.drbooker.diseases.data.DataManager;
import me.drbooker.diseases.utils.StringUtils;
import me.drbooker.diseases.utils.UserUtils;
import net.rafkos.mc.plugins.Caliditas.TemperatureState;
import net.rafkos.mc.plugins.Caliditas.events.PlayerTemperatureStateChanged;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerTemperatureChangeStateListener implements Listener {

    @EventHandler
    public void onStateChange(PlayerTemperatureStateChanged e) {
        Player p = e.getPlayer();
        TemperatureState state = e.getState();
        if(state == TemperatureState.COLD) {
            if(UserUtils.getDiseases(p).contains("hyperthermia")) return;
            if(DataManager.getInst().calculateChance(DataManager.getInst().hyperthermiaChance)) {
                p.sendTitle(StringUtils.color("&6&lHipotermia!"), StringUtils.color("&7Ogrzej sie jak najszybciej!"), 10, 40, 10);
                p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 0, false, false));
                UserUtils.addDisease(p, "hyperthermia");
            }
        } else if(state == TemperatureState.CHILL) {
            if(UserUtils.getDiseases(p).contains("hyperthermia")) {
                p.sendTitle(StringUtils.color("&a&lUdalo sie!"), StringUtils.color("&7Utrzymaj temperature ciala!"), 10, 40, 10);
                p.removePotionEffect(PotionEffectType.WITHER);
                UserUtils.removeDisease(p, "hyperthermia");
            }
        } else if(state == TemperatureState.HOT) {
            if(UserUtils.getDiseases(p).contains("fever")) return;
            if(DataManager.getInst().calculateChance(DataManager.getInst().feverChance)) {
                p.sendTitle(StringUtils.color("&6&lGoraczka!"), StringUtils.color("&7Zbij temperature sie jak najszybciej!"), 10, 40, 10);
                p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, Integer.MAX_VALUE, 0, false, false));
                UserUtils.addDisease(p, "fever");
            }
        } else if(state == TemperatureState.WARM) {
            if(UserUtils.getDiseases(p).contains("fever")) {
                p.sendTitle(StringUtils.color("&a&lUdalo sie!"), StringUtils.color("&7Utrzymaj temperature ciala!"), 10, 40, 10);
                p.removePotionEffect(PotionEffectType.WITHER);
                UserUtils.removeDisease(p, "fever");
            }
        }
    }
}
