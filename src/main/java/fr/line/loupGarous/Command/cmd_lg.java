package fr.line.loupGarous.Command;

import fr.line.loupGarous.LoupGarous;
import fr.line.loupGarous.Utils.Struct.Main_Struct;
import fr.line.loupGarous.Utils.Take_Id;
import fr.line.loupGarous.Utils.getHead;
import fr.line.loupGarous.Utils.getItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class cmd_lg implements CommandExecutor
{

    private boolean Verif_In_Party(String player_name)
    {
        Integer i = 0;

        while (i < LoupGarous.Game_List.size()) {
            if (LoupGarous.Game_List.get(i).getHost().equals(player_name))
                return true;
            i++;
        }
        return false;
    }

    private static void Set_Item(Integer index, Main_Struct Party, String Role, Inventory menu)
    {
        if (Party.getRole(Role) == 0)
            menu.setItem(index, getItem.getItem_0(Material.BARRIER, "§a§l" + Role, 1));
        else
            menu.setItem(index, getItem.getItem_0(Material.DRAGON_EGG, "§a§l" + Role, Party.getRole(Role)));
    }

    public static Inventory Create_Inventory(Player player)
    {
        Inventory menu = Bukkit.createInventory(player, 54, "Création de partie");
        Main_Struct Party = LoupGarous.Game_List.get(Take_Id.Party_id(player.getName()));

        // Partie pour le changement du nombres de joueurs
        menu.setItem(12, getItem.getItem_1(Material.IRON_INGOT, "§f§lRetirer des joueurs", 1, 7));
        menu.setItem(13, getHead.getHead_0(player.getName(), "§f§lNombre de joueurs", Party.getNb_Player()));
        menu.setItem(14, getItem.getItem_1(Material.DIAMOND, "§f§lAjouter des joueurs", 1, 7));

        // Partie pour la liste des rôles
        Set_Item(19, Party, "Villageois", menu);
        Set_Item(20, Party, "Voyante", menu);
        Set_Item(21, Party, "Sorciere", menu);
        Set_Item(22, Party, "Garde", menu);
        Set_Item(23, Party, "Cupidon", menu);
        Set_Item(24, Party, "Chasseur", menu);
        Set_Item(25, Party, "LoupGarou", menu);

        // Partie de start
        if (Party.getState() == 0 || Party.getState() == -1)
            menu.setItem(53, getItem.getItem_1(Material.COAL, "§a§lDémarrer la partie", 1, 7));

        return menu;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (msg.equalsIgnoreCase("lg"))
        {
            Player player = (Player) sender;
            if (LoupGarous.Game_List.isEmpty() || !Verif_In_Party(player.getName()))
            {
                Main_Struct Game = new Main_Struct(player.getName());
                LoupGarous.Game_List.add(Game);
            }
            player.openInventory(Create_Inventory(player));
        }
        return false;
    }
}
