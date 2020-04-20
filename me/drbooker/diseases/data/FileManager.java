package me.drbooker.diseases.data;

import me.drbooker.diseases.Diseases;

import java.io.File;

public class FileManager {

    public static void checkFileExistance() {
        if(!Diseases.getInst().getDataFolder().exists()) Diseases.getInst().getDataFolder().mkdir();
        if(!Diseases.getInst().playerDataFolder.exists()) Diseases.getInst().playerDataFolder.mkdir();
        File f = getConfigFile();
        if(!f.exists()) Diseases.getInst().saveResource(f.getName(), true);
    }

    public static File getConfigFile() {
        return new File(Diseases.getInst().getDataFolder(), "config.yml");
    }
}
