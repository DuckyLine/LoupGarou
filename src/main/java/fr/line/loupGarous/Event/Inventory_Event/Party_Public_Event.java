package fr.line.loupGarous.Event.Inventory_Event;

import fr.line.loupGarous.Inventory.Party_Public;
import fr.line.loupGarous.LoupGarous;
import org.bukkit.Location;
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

    private static String Return_Name_Host(String name)
    {
        int i = 0;

        while (i < name.length() && name.charAt(i) != ':')
            i++;
        return name.substring(i + 4);
    }

    private static void Join_Game(Player player, String name)
    {
        String Host = Return_Name_Host(name);
        Integer i = 0;

        while (i < LoupGarous.Game_List.size())
        {
            if (LoupGarous.Game_List.get(i).getHost().equalsIgnoreCase(Host))
            {
                if (LoupGarous.Game_List.get(i).getJoueurs().size() >= LoupGarous.Game_List.get(i).getNb_Player())
                {
                    player.sendMessage("§c§lErreur §cLa partie est complète !");
                    return;
                }
                player.sendMessage("§aVous venez de rejoindre la partie de §a§l" + Host + " §a!");
                LoupGarous.Game_List.get(i).addJoueur(player.getName());
                player.closeInventory();
                player.teleport(new Location(LoupGarous.plugin.getServer().getWorld("LoupGarou_Games"),
                        LoupGarous.Game_List.get(i).getX(),
                        Main_Menu.Find_Y_Position((int) (LoupGarous.Game_List.get(i).getX() + 1),
                        (int) (LoupGarous.Game_List.get(i).getX() + 1)), LoupGarous.Game_List.get(i).getX()));
                return;
            }
            i++;
        }
        player.sendMessage("§c§lErreur §cLa partie est introuvable !");
    }

    public static void Party_Public_Event(InventoryClickEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        Integer slot = event.getRawSlot();
        String name = event.getCurrentItem().getItemMeta().getDisplayName();

        event.setCancelled(true);
        switch (slot)
        {
            case 48:
                Before_Page(player);
                return;
            case 49:
                return;
            case 50:
                Next_Page(player);
        }
        if (name != null)
        {
            Join_Game(player, name);
        }
    }

}
