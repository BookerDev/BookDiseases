package me.drbooker.diseases.cmds.sub;

import me.drbooker.diseases.cmds.ICommand;
import me.drbooker.diseases.utils.InvUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GuiPagesCmd implements ICommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args[1].equalsIgnoreCase("1")) {
            Inventory inv = new InvUtils(1).getInventory();
            p.openInventory(inv);
        } else if(args[1].equalsIgnoreCase("2")) {
            Inventory inv = new InvUtils(2).getInventory();
            p.openInventory(inv);
        } else {
            Inventory inv = new InvUtils(0).getInventory();
            p.openInventory(inv);
        }
    }
}
