package fr.line.loupGarous.Event;

import fr.line.loupGarous.Event.Inventory_Event.Main_Menu;
import fr.line.loupGarous.Event.Inventory_Event.Party_Public_Event;
import fr.line.loupGarous.Event.Inventory_Event.Type_Party_Menu;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Inventory_Click implements Listener
{

    @EventHandler
    public void Inventory_Click(InventoryClickEvent event)
    {
        if (event.getView().getTitle().equalsIgnoreCase("Création de partie"))
            Main_Menu.Main_Menu(event);
        if (event.getView().getTitle().equalsIgnoreCase("Type de partie"))
            Type_Party_Menu.Type_Party_Menu(event);
        if (event.getView().getTitle().equalsIgnoreCase("Partie Public"))
            Party_Public_Event.Party_Public_Event(event);
    }

}
