package me.drbooker.diseases.items;

import me.drbooker.diseases.Diseases;
import me.drbooker.diseases.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemsManager {

    public static void registerItems() {
        ItemStack bandaz = new ItemStack(Material.PAPER, 5);
        ItemMeta bandazMeta = bandaz.getItemMeta();
        bandazMeta.setDisplayName(StringUtils.color("&c&lBandaż"));
        List<String> bandazLore = new ArrayList<String>();
        bandazLore.add(StringUtils.color("&7Przydaje sie do leczenia"));
        bandazLore.add(StringUtils.color("&7uszkodzen mechanicznych."));
        bandazMeta.setLore(bandazLore);
        bandaz.setItemMeta(bandazMeta);
        NamespacedKey bandazKey = new NamespacedKey(Diseases.getInst(), "bandaz_key");
        ShapedRecipe bandazRecipe = new ShapedRecipe(bandazKey, bandaz);
        bandazRecipe.shape("PPP", "PWP", "PPP");
        bandazRecipe.setIngredient('P', Material.PAPER);
        bandazRecipe.setIngredient('W', Material.WHITE_WOOL);
        Bukkit.addRecipe(bandazRecipe);

        ItemStack antybiotyki = new ItemStack(Material.PUMPKIN_SEEDS, 1);
        ItemMeta antybiotykiMeta = antybiotyki.getItemMeta();
        antybiotykiMeta.setDisplayName(StringUtils.color("&c&lAntybiotyki"));
        List<String> antybiotykiLore = new ArrayList<String>();
        antybiotykiLore.add(StringUtils.color("&7Przydaje sie do leczenia"));
        antybiotykiLore.add(StringUtils.color("&7wielu chorob bakteryjnych."));
        antybiotykiMeta.setLore(antybiotykiLore);
        antybiotyki.setItemMeta(antybiotykiMeta);
        NamespacedKey antybiotykiKey = new NamespacedKey(Diseases.getInst(), "antybiotyki_key");
        ShapedRecipe antybiotykiRecipe = new ShapedRecipe(antybiotykiKey, antybiotyki);
        antybiotykiRecipe.shape("***", "SWR", "***");
        antybiotykiRecipe.setIngredient('S', Material.FERMENTED_SPIDER_EYE);
        antybiotykiRecipe.setIngredient('W', Material.POTION);
        antybiotykiRecipe.setIngredient('R', Material.ROTTEN_FLESH);
        antybiotykiRecipe.setIngredient('*', Material.AIR);
        Bukkit.addRecipe(antybiotykiRecipe);

        ItemStack inhibitory = new ItemStack(Material.SUGAR, 2);
        ItemMeta inhibitoryMeta = inhibitory.getItemMeta();
        inhibitoryMeta.setDisplayName(StringUtils.color("&c&lInhibitory neuraminidazy"));
        List<String> inhibitoryLore = new ArrayList<String>();
        inhibitoryLore.add(StringUtils.color("&7Przydaje sie do leczenia"));
        inhibitoryLore.add(StringUtils.color("&7wielu rodzajow grypy."));
        inhibitoryMeta.setLore(inhibitoryLore);
        inhibitory.setItemMeta(inhibitoryMeta);
        NamespacedKey inhibitoryKey = new NamespacedKey(Diseases.getInst(), "inhibitory_key");
        ShapedRecipe inhibitoryRecipe = new ShapedRecipe(inhibitoryKey, inhibitory);
        inhibitoryRecipe.shape("SSS", "*W*", "PCB");
        inhibitoryRecipe.setIngredient('S', Material.SUGAR);
        inhibitoryRecipe.setIngredient('W', Material.POTION);
        inhibitoryRecipe.setIngredient('P', Material.PORKCHOP);
        inhibitoryRecipe.setIngredient('B', Material.BEEF);
        inhibitoryRecipe.setIngredient('C', Material.CHICKEN);
        inhibitoryRecipe.setIngredient('*', Material.AIR);
        Bukkit.addRecipe(inhibitoryRecipe);
    }
}