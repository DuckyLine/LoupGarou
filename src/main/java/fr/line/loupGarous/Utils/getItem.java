package fr.line.loupGarous.Utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class getItem
{

    public static ItemStack getItem_1(Material material, String name, Integer quantity, Integer data)
    {
        ItemStack item = new ItemStack(material, quantity);
        ItemMeta item_meta = item.getItemMeta();
        item_meta.setDisplayName(name);
        item_meta.setCustomModelData(data);
        item.setItemMeta(item_meta);
        return item;
    }
    public static ItemStack getItem_0(Material material, String name, Integer quantity)
    {
        ItemStack item = new ItemStack(material, quantity);
        ItemMeta item_meta = item.getItemMeta();
        item_meta.setDisplayName(name);
        item.setItemMeta(item_meta);
        return item;
    }

}
