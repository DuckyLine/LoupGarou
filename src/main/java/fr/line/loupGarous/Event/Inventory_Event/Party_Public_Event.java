package fr.line.loupGarous.Event.Inventory_Event;

import fr.line.loupGarous.Inventory.Party_Public;
import fr.line.loupGarous.LoupGarous;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Party_Public_Event
{

    private static void Next_Page(Player player)
    {
        Integer Page = 0;
        if (LoupGarous.Player_Page.containsKey(player.getName()))
            Page = LoupGarous.Player_Page.get(player.getName());
        if (LoupGarous.List_Lobby.size() / 28 < Page + 1)
        {
            player.sendMessage("§c§lErreur §cIl n'y a pas plus de page !");
            return;
        }
        Page += 1;
        LoupGarous.Player_Page.put(player.getName(), Page);
        player.openInventory(Party_Public.Party_Public(player, Page * 28));
    }

    private static void Before_Page(Player player)
    {
        Integer Page = 0;
        if (LoupGarous.Player_Page.containsKey(player.getName()))
            Page = LoupGarous.Player_Page.get(player.getName());
        if (Page == 0)
        {
            player.sendMessage("§c§lErreur §cVous êtes déjà sur la première page !");
            return;
        }
        Page -= 1;
        LoupGarous.Player_Page.put(player.getName(), Page);
        player.openInventory(Party_Public.Party_Public(player, Page * 28));
    }

    public static void Party_Public_Event(InventoryClickEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        Integer slot = event.getRawSlot();

        event.setCancelled(true);
        switch (slot)
        {
            case 48:
                Before_Page(player);
                return;
            case 50:
                Next_Page(player);
        }
    }

}
