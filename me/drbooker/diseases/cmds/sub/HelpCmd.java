package me.drbooker.diseases.cmds.sub;

import me.drbooker.diseases.cmds.ICommand;
import me.drbooker.diseases.utils.StringUtils;
import org.bukkit.command.CommandSender;

public class HelpCmd implements ICommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage(StringUtils.color(StringUtils.prefix + "&4Blad: niepoprawnie uzyles komende /leki"));
    }
}
