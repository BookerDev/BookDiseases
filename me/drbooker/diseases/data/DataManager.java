package me.drbooker.diseases.data;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Random;

public class DataManager {

    private static DataManager inst;

    private YamlConfiguration cfg;

    public int bandageChance;
    public int antibioticsChance;
    public int inhibitorChance;

    public int brokenLegChance;
    public int zombieInfect;
    public int pigInfect;
    public int hyperthermiaChance;
    public int feverChance;

    private DataManager() {
        inst = this;
    }

    public void loadConfig() {
        FileManager.checkFileExistance();

        cfg = YamlConfiguration.loadConfiguration(FileManager.getConfigFile());

        this.bandageChance = cfg.getInt("bandageChance");
        this.antibioticsChance = cfg.getInt("antibioticsChance");
        this.inhibitorChance = cfg.getInt("inhibitorChance");

        this.brokenLegChance = cfg.getInt("brokenLegChance");
        this.pigInfect = cfg.getInt("pigInfect");
        this.zombieInfect = cfg.getInt("zombieInfect");
        this.hyperthermiaChance = cfg.getInt("hyperthermiaChance");
        this.feverChance = cfg.getInt("feverChance");

    }

    public boolean calculateChance(int chance) {
        Random r = new Random();
        if(chance >= 1 + r.nextInt(100)) return true;
        return false;
    }

    public static DataManager getInst() {
        if(inst != null) return inst;
        return new DataManager();
    }
}
