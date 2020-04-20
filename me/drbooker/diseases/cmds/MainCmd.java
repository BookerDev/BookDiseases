package me.drbooker.diseases.cmds;

import me.drbooker.diseases.cmds.sub.GuiCmd;
import me.drbooker.diseases.cmds.sub.GuiPagesCmd;
import me.drbooker.diseases.cmds.sub.HelpCmd;
import me.drbooker.diseases.cmds.sub.ReloadCmd;
import me.drbooker.diseases.utils.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class MainCmd implements CommandExecutor {

    private static Map<String, ICommand> subCmds = new HashMap<String, ICommand>();

    public MainCmd() {
        subCmds.put("one", new GuiCmd());
        subCmds.put("help", new HelpCmd());
        subCmds.put("reload", new ReloadCmd());
        subCmds.put("gui", new GuiPagesCmd());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            if(cmd.getName().equalsIgnoreCase("leki")) {
                if(sender instanceof Player) {
                    if (args.length == 0) {
                        subCmds.get("one").execute(sender, args);
                    } else {
                        if (subCmds.containsKey(args[0].toLowerCase())) {
                            subCmds.get(args[0].toLowerCase()).execute(sender, args);
                        } else {
                            subCmds.get("help").execute(sender, args);
                        }
                    }
                } else {
                    sender.sendMessage(StringUtils.color("&4Tylko gracz moze uzyc tej komendy!"));
                }
            }
        return false;
    }
}
