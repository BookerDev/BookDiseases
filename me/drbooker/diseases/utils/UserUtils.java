package me.drbooker.diseases.utils;

import me.drbooker.diseases.Diseases;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UserUtils {

    public static void initUser(Player p) {
        String name = p.getName();
        String uuid = p.getUniqueId().toString();
        File pFile = new File(Diseases.getInst().playerDataFolder, uuid + ".yml");
        try {
            pFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        YamlConfiguration pCfg = YamlConfiguration.loadConfiguration(pFile);
        pCfg.set("name", name);
        pCfg.set("uuid", uuid);
        pCfg.createSection("diseases");
        try {
            pCfg.save(pFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkFile(Player p) {
        String uuid = p.getUniqueId().toString();
        File pFile = new File(Diseases.getInst().playerDataFolder, uuid + ".yml");
        if(pFile.exists()) return true;
        return false;
    }

    public static File getFile(Player p) {
        String uuid = p.getUniqueId().toString();
        File pFile = new File(Diseases.getInst().playerDataFolder, uuid + ".yml");
        if (checkFile(p)) return pFile;
        initUser(p);
        return pFile;
    }

    public static List<String> getDiseases(Player p) {
        File pFile = getFile(p);
        YamlConfiguration pCfg = YamlConfiguration.loadConfiguration(pFile);
        return pCfg.getStringList("diseases");
    }

    public static void addDisease(Player p, String disease) {
        File pFile = getFile(p);
        YamlConfiguration pCfg = YamlConfiguration.loadConfiguration(pFile);
        List<String> diseases = getDiseases(p);
        diseases.add(disease);
        pCfg.set("diseases", diseases);
        try {
            pCfg.save(pFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void removeDisease(Player p, String disease) {
        File pFile = getFile(p);
        YamlConfiguration pCfg = YamlConfiguration.loadConfiguration(pFile);
        List<String> diseases = getDiseases(p);
        diseases.remove(disease);
        pCfg.set("diseases", diseases);
        try {
            pCfg.save(pFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDiseases(Player p) {
        File pFile = getFile(p);
        YamlConfiguration pCfg = YamlConfiguration.loadConfiguration(pFile);
        List<String> diseases = getDiseases(p);
        diseases.clear();
        pCfg.set("diseases", diseases);
        try {
            pCfg.save(pFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}