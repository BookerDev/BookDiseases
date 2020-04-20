package me.drbooker.diseases.utils;

import org.bukkit.ChatColor;

public class StringUtils {

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static String prefix = StringUtils.color("&8[&c&lLEKI&r&8]&r ");
}
