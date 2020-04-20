package me.drbooker.diseases.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.Arrays;
import java.util.UUID;

public class InvUtils implements InventoryHolder {

    private final Inventory inv;

    private final ItemStack leftArrow = itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzdhZWU5YTc1YmYwZGY3ODk3MTgzMDE1Y2NhMGIyYTdkNzU1YzYzMzg4ZmYwMTc1MmQ1ZjQ0MTlmYzY0NSJ9fX0=", StringUtils.color("&7&lPoprzednia strona"));
    private final ItemStack rightArrow = itemFromBase64("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjgyYWQxYjljYjRkZDIxMjU5YzBkNzVhYTMxNWZmMzg5YzNjZWY3NTJiZTM5NDkzMzgxNjRiYWM4NGE5NmUifX19", StringUtils.color("&7&lNastepna strona"));
    private final ItemStack blackPane = createGuiItem(Material.BLACK_STAINED_GLASS_PANE, 1, " ", "");
    private final ItemStack whitePane = createGuiItem(Material.WHITE_STAINED_GLASS_PANE, 1, " ", "");
    private final ItemStack paper = createGuiItem(Material.PAPER, 1, "&rPapier");
    private final ItemStack bandaz = createGuiItem(Material.PAPER, 5, "&c&lBandaż",StringUtils.color("&7Przydaje sie do leczenia"), StringUtils.color("&7uszkodzen mechanicznych."));
    private final ItemStack wool = createGuiItem(Material.WHITE_WOOL, 1, "&rWelna");
    private final ItemStack fermentedEye = createGuiItem(Material.FERMENTED_SPIDER_EYE, 1, "&rSfermentowane oko pajaka");
    private final ItemStack flesh = createGuiItem(Material.ROTTEN_FLESH, 1, "&rZgnile mieso");
    private final ItemStack waterBottle = createPotionGui(PotionType.WATER, 1, "&rButelka wody");
    private final ItemStack antibiotics = createGuiItem(Material.PUMPKIN_SEEDS, 1, "&c&lAntybiotyki", StringUtils.color("&7Przydaje sie do leczenia"), StringUtils.color("&7wielu chorob bakteryjnych."));

    public InvUtils(int page) {
        inv = Bukkit.createInventory(this, 54, StringUtils.color("&lCraftingi " + page));
        initializeItems(page);
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }

    public void initializeItems(int page) {
        if(page == 1) {
            inv.setItem(0, leftArrow);
            inv.setItem(1, blackPane);
            inv.setItem(2, blackPane);
            inv.setItem(3, blackPane);
            inv.setItem(4, blackPane);
            inv.setItem(5, blackPane);
            inv.setItem(6, blackPane);
            inv.setItem(7, blackPane);
            inv.setItem(8, rightArrow);
            inv.setItem(9, whitePane);
            inv.setItem(10, whitePane);
            inv.setItem(11, whitePane);
            inv.setItem(12, whitePane);
            inv.setItem(13, whitePane);
            inv.setItem(14, whitePane);
            inv.setItem(15, whitePane);
            inv.setItem(16, whitePane);
            inv.setItem(17, whitePane);
            inv.setItem(18, whitePane);
            inv.setItem(19, paper);
            inv.setItem(20, paper);
            inv.setItem(21, paper);
            inv.setItem(22, whitePane);
            inv.setItem(23, whitePane);
            inv.setItem(24, whitePane);
            inv.setItem(25, whitePane);
            inv.setItem(26, whitePane);
            inv.setItem(27, whitePane);
            inv.setItem(28, paper);
            inv.setItem(29, wool);
            inv.setItem(30, paper);
            inv.setItem(31, whitePane);
            inv.setItem(32, whitePane);
            inv.setItem(33, whitePane);
            inv.setItem(34, bandaz);
            inv.setItem(35, whitePane);
            inv.setItem(36, whitePane);
            inv.setItem(37, paper);
            inv.setItem(38, paper);
            inv.setItem(39, paper);
            inv.setItem(40, whitePane);
            inv.setItem(41, whitePane);
            inv.setItem(42, whitePane);
            inv.setItem(43, whitePane);
            inv.setItem(44, whitePane);
            inv.setItem(45, whitePane);
            inv.setItem(46, whitePane);
            inv.setItem(47, whitePane);
            inv.setItem(48, whitePane);
            inv.setItem(49, whitePane);
            inv.setItem(50, whitePane);
            inv.setItem(51, whitePane);
            inv.setItem(52, whitePane);
            inv.setItem(53, whitePane);
        } else if(page == 2) {
            inv.setItem(0, leftArrow);
            inv.setItem(1, blackPane);
            inv.setItem(2, blackPane);
            inv.setItem(3, blackPane);
            inv.setItem(4, blackPane);
            inv.setItem(5, blackPane);
            inv.setItem(6, blackPane);
            inv.setItem(7, blackPane);
            inv.setItem(8, rightArrow);
            inv.setItem(9, whitePane);
            inv.setItem(10, whitePane);
            inv.setItem(11, whitePane);
            inv.setItem(12, whitePane);
            inv.setItem(13, whitePane);
            inv.setItem(14, whitePane);
            inv.setItem(15, whitePane);
            inv.setItem(16, whitePane);
            inv.setItem(17, whitePane);
            inv.setItem(18, whitePane);
            inv.setItem(19, whitePane);
            inv.setItem(20, whitePane);
            inv.setItem(21, whitePane);
            inv.setItem(22, whitePane);
            inv.setItem(23, whitePane);
            inv.setItem(24, whitePane);
            inv.setItem(25, whitePane);
            inv.setItem(26, whitePane);
            inv.setItem(27, whitePane);
            inv.setItem(28, fermentedEye);
            inv.setItem(29, waterBottle);
            inv.setItem(30, flesh);
            inv.setItem(31, whitePane);
            inv.setItem(32, whitePane);
            inv.setItem(33, whitePane);
            inv.setItem(34, antibiotics);
            inv.setItem(35, whitePane);
            inv.setItem(36, whitePane);
            inv.setItem(37, whitePane);
            inv.setItem(38, whitePane);
            inv.setItem(39, whitePane);
            inv.setItem(40, whitePane);
            inv.setItem(41, whitePane);
            inv.setItem(42, whitePane);
            inv.setItem(43, whitePane);
            inv.setItem(44, whitePane);
            inv.setItem(45, whitePane);
            inv.setItem(46, whitePane);
            inv.setItem(47, whitePane);
            inv.setItem(48, whitePane);
            inv.setItem(49, whitePane);
            inv.setItem(50, whitePane);
            inv.setItem(51, whitePane);
            inv.setItem(52, whitePane);
            inv.setItem(53, whitePane);
        } else {
            for(int i=0;i<=53;i++) {
                inv.setItem(i, whitePane);
            }
        }
    }

    private ItemStack createGuiItem(final Material material, final int number, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, number);
        if(item.getItemMeta() == null) return item;
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(StringUtils.color(name));
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    private ItemStack createGuiItem(final Material material, final int number, final String name) {
        final ItemStack item = new ItemStack(material, number);
        if(item.getItemMeta() == null) return item;
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(StringUtils.color(name));
        item.setItemMeta(meta);
        return item;
    }


    private ItemStack createPotionGui(final PotionType potionType, final int number, final String name, final String... lore) {
        final ItemStack item = new ItemStack(Material.POTION, number);
        if(item.getItemMeta() == null) return item;
        final PotionMeta meta = (PotionMeta) item.getItemMeta();
        meta.clearCustomEffects();
        meta.setBasePotionData(new PotionData(potionType));
        meta.setDisplayName(StringUtils.color(name));
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }

    public void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    }

    private static ItemStack itemFromBase64(String base64, String displayName) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemStack skull = itemWithBase64(item, base64);
        if(skull.getItemMeta() == null) return skull;
        ItemMeta im = skull.getItemMeta();
        im.setDisplayName(displayName);
        skull.setItemMeta(im);
        return skull;
    }

    @SuppressWarnings("deprecation")
    private static ItemStack itemWithBase64(final ItemStack item, final String base64) {
        UUID hashAsId = new UUID(base64.hashCode(), base64.hashCode());
        return Bukkit.getUnsafe().modifyItemStack(item,
                "{SkullOwner:{Id:\"" + hashAsId + "\",Properties:{textures:[{Value:\"" + base64 + "\"}]}}}"
        );
    }
}