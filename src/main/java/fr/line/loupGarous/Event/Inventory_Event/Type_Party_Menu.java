package fr.line.loupGarous.Event.Inventory_Event;

import fr.line.loupGarous.Inventory.Party_Public;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Type_Party_Menu
{

    public static void Type_Party_Menu(InventoryClickEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        Integer slot = event.getRawSlot();

        event.setCancelled(true);
        switch (slot)
        {
            case 3:
                player.sendMessage("§4§lSOON !");
                return;
            case 5:
                player.openInventory(Party_Public.Party_Public(player, 0));
        }
    }

}
