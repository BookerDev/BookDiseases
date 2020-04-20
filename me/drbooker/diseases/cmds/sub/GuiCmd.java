package me.drbooker.diseases.cmds.sub;

import me.drbooker.diseases.cmds.ICommand;
import me.drbooker.diseases.utils.InvUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GuiCmd implements ICommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        Inventory inv = new InvUtils(1).getInventory();
        p.openInventory(inv);
    }
}