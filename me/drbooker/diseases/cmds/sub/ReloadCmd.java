package me.drbooker.diseases.cmds.sub;

import me.drbooker.diseases.cmds.ICommand;
import me.drbooker.diseases.data.DataManager;
import me.drbooker.diseases.utils.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCmd implements ICommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(p.hasPermission("leki.reload")) {
            DataManager.getInst().loadConfig();
            p.sendMessage(StringUtils.prefix + StringUtils.color("&7Pomyslnie przeladowales plugin!"));
        } else {
            p.sendMessage(StringUtils.prefix + StringUtils.color("&4Blad: nie masz permisji do tej komendy."));
        }
    }
}
