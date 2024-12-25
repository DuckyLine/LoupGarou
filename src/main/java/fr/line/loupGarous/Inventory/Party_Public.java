package fr.line.loupGarous.Inventory;

import com.sun.tools.javac.Main;
import fr.line.loupGarous.LoupGarous;
import fr.line.loupGarous.Utils.Struct.Main_Struct;
import fr.line.loupGarous.Utils.Take_Id;
import fr.line.loupGarous.Utils.getHead;
import fr.line.loupGarous.Utils.getItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Party_Public
{

    private static Integer Slot_Changing(Integer slot)
    {
        if (slot == 17)
            return 19;
        else if (slot == 26)
            return 28;
        else if (slot == 35)
            return 37;
        else if (slot == 44)
            return -1;
        return slot;
    }

    public static Inventory Party_Public(Player player, Integer i)
    {
        Inventory menu = Bukkit.createInventory(player, 54, "Partie Public");
        Main_Struct Party;
        Integer slot = 10;

        // Ajout des parties
        while (i < LoupGarous.List_Lobby.size() && slot != -1)
        {
            Party = LoupGarous.Game_List.get(Take_Id.Party_id(LoupGarous.List_Lobby.get(i)));
            if (Party.getState() == 1)
            {
                menu.setItem(slot, getHead.getHead_1(Party.getHost(), "§6§nPartie de:§f " + Party.getHost(), 1, Party));
                slot++;
            }
            slot = Slot_Changing(slot);
            i++;
        }

        // Ajout du système de page
        menu.setItem(48, getItem.getItem_1(Material.PAPER, "§f§lPage Précédente", 1, 7));
        menu.setItem(49, getItem.getItem_1(Material.SUNFLOWER, "§e§lPage Actuelle", 1, 7));
        menu.setItem(50, getItem.getItem_1(Material.PAPER, "§f§lPage Suivantre", 1, 7));

        return menu;
    }

}
