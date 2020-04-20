package me.drbooker.diseases;

import me.drbooker.diseases.cmds.MainCmd;
import me.drbooker.diseases.data.DataManager;
import me.drbooker.diseases.items.ItemsManager;
import me.drbooker.diseases.listeners.*;
import me.drbooker.diseases.utils.InvUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Diseases extends JavaPlugin {

    private static Diseases instance;

    public File playerDataFolder = new File(this.getDataFolder() + File.separator + "playerData");

    public Diseases() {
        instance = this;
    }

    @Override
    public void onEnable() {
        instance = this;
        DataManager.getInst().loadConfig();
        ItemsManager.registerItems();
        registerEvents();
        getCommand("leki").setExecutor(new MainCmd());
    }

    @Override
    public void onDisable() { instance = null; }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new FallDamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerRespawnListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerConsumeListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerDamageByEntityListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerTemperatureChangeStateListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerHitPigListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
    }

    public static Diseases getInst() {
        if(instance != null) return instance;
        return new Diseases();
    }
}