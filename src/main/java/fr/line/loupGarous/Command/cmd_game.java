package fr.line.loupGarous.Command;

import fr.line.loupGarous.LoupGarous;
import fr.line.loupGarous.Utils.getItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class cmd_game implements CommandExecutor
{

    private static Inventory Create_Inventory_1(Player player)
    {
        Inventory menu = Bukkit.createInventory(player, 9, "Type de partie");

        menu.setItem(3, getItem.getItem_1(Material.COPPER_INGOT, "§c§lPartie Privée", 1, 7));
        menu.setItem(5, getItem.getItem_1(Material.GOLD_INGOT, "§a§lPartie Publique", 1, 7));
        return menu;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (msg.equalsIgnoreCase("game"))
        {
            Player player = (Player) sender;

            if (player.getWorld().getName().equalsIgnoreCase("LoupGarou_Games"))
            {
                player.sendMessage("§c§lErreur §cVous êtes déjà dans une partie !");
                return false;
            }
            player.openInventory(Create_Inventory_1(player));
            LoupGarous.Player_Page.put(player.getName(), 0);
        }
        return false;
    }

}
