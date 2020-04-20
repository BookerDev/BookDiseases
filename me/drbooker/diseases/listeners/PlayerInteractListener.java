package me.drbooker.diseases.listeners;

import me.drbooker.diseases.data.DataManager;
import me.drbooker.diseases.utils.StringUtils;
import me.drbooker.diseases.utils.UserUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void onUse(PlayerInteractEvent e) {
        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Player p = e.getPlayer();
            if(e.getItem() == null) return;
            ItemStack item = e.getItem();
            if(item.getItemMeta() == null) return;
            ItemMeta itemMeta = item.getItemMeta();
            if(item.getType() == Material.PAPER && itemMeta.getDisplayName().equalsIgnoreCase(StringUtils.color("&c&lBandaż"))) {
                if(UserUtils.getDiseases(p).contains("brokenLeg")) {
                    if (p.getInventory().getItemInMainHand().getAmount() > 1) {
                        p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                    } else {
                        p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                    }
                    if (DataManager.getInst().calculateChance(DataManager.getInst().bandageChance)) {
                        p.sendTitle(StringUtils.color("&a&lUdalo sie!"), StringUtils.color("&7Twoja noga jest juz zdrowa!"), 5, 20, 5);
                        p.removePotionEffect(PotionEffectType.SLOW);
                        UserUtils.removeDisease(p, "brokenLeg");
                    } else {
                        p.sendTitle(StringUtils.color("&c&lNie udalo sie!"), StringUtils.color("&7Sprobuj ponownie uzyc bandaza!"), 10, 40, 10);
                    }
                } else {
                    p.sendMessage(StringUtils.color("&4Nie uzywaj bandazy bez sensu!"));
                }
            } else if(item.getType() == Material.PUMPKIN_SEEDS && itemMeta.getDisplayName().equalsIgnoreCase(StringUtils.color("&c&lAntybiotyki"))) {
                if(UserUtils.getDiseases(p).contains("zombieInfect")) {
                    if (p.getInventory().getItemInMainHand().getAmount() > 1) {
                        p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                    } else {
                        p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                    }
                    if (DataManager.getInst().calculateChance(DataManager.getInst().antibioticsChance)) {
                        p.sendTitle(StringUtils.color("&a&lUdalo sie!"), StringUtils.color("&7Wyzdrowiales!"), 5, 20, 5);
                        p.removePotionEffect(PotionEffectType.CONFUSION);
                        p.removePotionEffect(PotionEffectType.WEAKNESS);
                        UserUtils.removeDisease(p, "zombieInfect");
                    } else {
                        p.sendTitle(StringUtils.color("&c&lNie udalo sie!"), StringUtils.color("&7Sprobuj zazyc antybiotyki ponownie!"), 10, 40, 10);
                    }
                } else {
                    p.sendMessage(StringUtils.color("&4Nie uzywaj antybiotykow bez sensu!"));
                }
            } else if(item.getType() == Material.SUGAR && itemMeta.getDisplayName().equalsIgnoreCase(StringUtils.color("&c&lInhibitory neuraminidazy"))) {
                if (UserUtils.getDiseases(p).contains("pigInfect")) {
                    if (p.getInventory().getItemInMainHand().getAmount() > 1) {
                        p.getInventory().getItemInMainHand().setAmount(p.getInventory().getItemInMainHand().getAmount() - 1);
                    } else {
                        p.getInventory().setItemInMainHand(new ItemStack(Material.AIR));
                    }
                    if (DataManager.getInst().calculateChance(DataManager.getInst().inhibitorChance)) {
                        p.sendTitle(StringUtils.color("&a&lUdalo sie!"), StringUtils.color("&7Wyzdrowiales!"), 5, 20, 5);
                        p.removePotionEffect(PotionEffectType.CONFUSION);
                        p.removePotionEffect(PotionEffectType.WEAKNESS);
                        UserUtils.removeDisease(p, "pigInfect");
                        Bukkit.getScheduler().cancelTask(PlayerHitPigListener.pigInfectTask);
                    } else {
                        p.sendTitle(StringUtils.color("&c&lNie udalo sie!"), StringUtils.color("&7Sprobuj zazyc inhibitory ponownie!"), 10, 40, 10);
                    }
                } else {
                    p.sendMessage(StringUtils.color("&4Nie uzywaj inhibitorow bez sensu!"));
                }
            }
        }
    }
}
