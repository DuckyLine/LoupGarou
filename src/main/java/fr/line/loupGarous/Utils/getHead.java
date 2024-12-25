package fr.line.loupGarous.Utils;

import fr.line.loupGarous.LoupGarous;
import fr.line.loupGarous.Start.Role;
import fr.line.loupGarous.Utils.Struct.Main_Struct;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class getHead
{

    public static ItemStack getHead_1(String playerName, String name, Integer quantity, Main_Struct Party)
    {
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, quantity);
        SkullMeta skullMeta = (SkullMeta) playerHead.getItemMeta();
        List<String> Lore = new ArrayList<>();
        Integer i = 0;

        // Appliquer la texture de la tête
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(playerName));

        // Appliquer le lore
        Lore.add("§f");
        Lore.add("§fJoueur: §e" + Party.getJoueurs().size() + "§6§l/§e" + Party.getNb_Player());
        Lore.add("§f");

        // Lore pour les rôles
        while (i < LoupGarous.List_Role.size())
        {
            if (Party.getRole(LoupGarous.List_Role.get(i)) > 0)
                Lore.add("§a§l" + LoupGarous.List_Role.get(i) + ": §f" + Party.getRole(LoupGarous.List_Role.get(i)));
            i++;
        }

        skullMeta.setLore(Lore);
        skullMeta.setDisplayName(name);
        playerHead.setItemMeta(skullMeta);
        return playerHead;
    }

    public static ItemStack getHead_0(String playerName, String name, Integer quantity)
    {
        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, quantity);
        SkullMeta skullMeta = (SkullMeta) playerHead.getItemMeta();

        // Appliquer la texture de la tête
        skullMeta.setOwningPlayer(Bukkit.getOfflinePlayer(playerName));

        skullMeta.setDisplayName(name);
        playerHead.setItemMeta(skullMeta);
        return playerHead;
    }

}
