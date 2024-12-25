package fr.line.loupGarous.Event;

import fr.line.loupGarous.Event.Close_Inventory.Main_Menu_Close;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class Inventory_Close implements Listener
{

    @EventHandler
    public void Inventory_Close(InventoryCloseEvent event)
    {
        if (event.getView().getTitle().equalsIgnoreCase("Création de partie"))
            Main_Menu_Close.Main_Menu_Close(event);
    }
}


