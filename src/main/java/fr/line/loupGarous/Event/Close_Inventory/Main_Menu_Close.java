package fr.line.loupGarous.Event.Close_Inventory;

import fr.line.loupGarous.LoupGarous;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class Main_Menu_Close {

    public static void Main_Menu_Close(InventoryCloseEvent event)
    {
        Player player = (Player) event.getPlayer();
        int i = 0;

        while (LoupGarous.Game_List.get(i).getHost() != player.getName())
            i++;
        if (LoupGarous.Game_List.get(i).getState() == 0)
        {
            LoupGarous.Game_List.remove(i);
            return;
        }

        // Vérification si la game n'ai pas start
        if (LoupGarous.Game_List.get(i).getState() == -1)
            LoupGarous.Game_List.get(i).setState(0);
    }

}
