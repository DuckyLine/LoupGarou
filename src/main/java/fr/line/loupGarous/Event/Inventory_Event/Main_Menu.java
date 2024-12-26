package fr.line.loupGarous.Event.Inventory_Event;

import fr.line.loupGarous.Command.cmd_lg;
import fr.line.loupGarous.Command.cmd_paste;
import fr.line.loupGarous.LoupGarous;
import fr.line.loupGarous.Utils.Nb_Role_Game;
import fr.line.loupGarous.Utils.Take_Id;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Main_Menu {

    public static Integer x_Position = 99;
    public static Integer z_Position = 99;

    public static Integer Find_Y_Position(Integer x, Integer z)
    {
        Integer y = 200;

        while (LoupGarous.plugin.getServer().getWorld("LoupGarou_Games").getBlockAt(x, y, z).getType() == Material.AIR)
            y--;
        return y + 1;
    }

    private static void Start_Game(Player player, Integer id)
    {
        player.sendMessage("§aVous venez de créer votre partie de Loup-Garou !");
        LoupGarous.Game_List.get(id).setState(1);
        LoupGarous.List_Lobby.add(player.getName());
        player.closeInventory();
        cmd_paste.Create_Map("lg_1", x_Position, z_Position);
        player.teleport(new Location(LoupGarous.plugin.getServer().getWorld("LoupGarou_Games"), LoupGarous.Game_List.get(id).getX(),
                Find_Y_Position((int) (LoupGarous.Game_List.get(id).getX() + 1), (int) (LoupGarous.Game_List.get(id).getZ() + 1)), LoupGarous.Game_List.get(id).getZ()));
    }

    private static void Left_Arrow(Integer id, Player player)
    {
        Integer Nb_Player =  LoupGarous.Game_List.get(id).getNb_Player();
        if (Nb_Player != 1)
        {
            if (Nb_Role_Game.Nb_Role_Game(id) > Nb_Player - 1)
            {
                player.sendMessage("§c§lErreur §cVeuillez retirer des rôles pour pouvoir baisser la limite de joueurs maximum !");
                return;
            }
            if (LoupGarous.Game_List.get(id).getState() == 0)
                LoupGarous.Game_List.get(id).setState(-1);
            LoupGarous.Game_List.get(id).setNb_Player(Nb_Player - 1);
            player.openInventory(cmd_lg.Create_Inventory(player));
        }
    }

    private static void Right_Arrow(Integer id, Player player)
    {
        if (LoupGarous.Game_List.get(id).getState() == 0)
            LoupGarous.Game_List.get(id).setState(-1);
        Integer Nb_Player =  LoupGarous.Game_List.get(id).getNb_Player();
        LoupGarous.Game_List.get(id).setNb_Player(Nb_Player + 1);
        player.openInventory(cmd_lg.Create_Inventory(player));
    }

    private static void Case_Role(Integer id, Player player, String role, InventoryClickEvent event)
    {
        Integer n = LoupGarous.Game_List.get(id).getRole(role);
        if (event.getClick().isLeftClick())
        {
            if (Nb_Role_Game.Nb_Role_Game(id) + 1 > LoupGarous.Game_List.get(id).getNb_Player())
            {
                player.sendMessage("§c§lErreur §cVeuillez augmenter le nombre de joueurs maximum dans votre partie !");
                return;
            }
            LoupGarous.Game_List.get(id).setRole(role, n + 1);
        }
        else if (n >= 1)
            LoupGarous.Game_List.get(id).setRole(role, n - 1);
        if (LoupGarous.Game_List.get(id).getState() == 0)
            LoupGarous.Game_List.get(id).setState(-1);
        player.openInventory(cmd_lg.Create_Inventory(player));
    }

    private static void Delete_Game(Integer id, Player player)
    {
        Player joueur;
        Integer i = 0;
        Integer j = 0;

        while (!LoupGarous.List_Lobby.get(i).equalsIgnoreCase(player.getName()))
            i++;
        LoupGarous.List_Lobby.remove((int)i);
        while (j < LoupGarous.Game_List.get(id).getJoueurs().size())
        {
            joueur = (Player) Bukkit.getOfflinePlayer(LoupGarous.Game_List.get(id).getJoueurs().get(j));
            joueur.teleport(new Location(LoupGarous.plugin.getServer().getWorld("World"), 0, 100, 0));
            joueur.sendMessage("§cLa partie viens d'être supprimé !");
            j++;
        }
        LoupGarous.Game_List.remove((int)id);
    }

    public static void Main_Menu(InventoryClickEvent event)
    {
        Player player = (Player) event.getWhoClicked();
        Integer slot = event.getRawSlot();
        Integer id = Take_Id.Party_id(player.getName());
        event.setCancelled(true);
        switch (slot)
        {
            case 53:
                Start_Game(player, id);
                return;
            case 45:
                Delete_Game(id, player);
                return;
            case 12:
                Left_Arrow(id, player);
                return;
            case 14:
                Right_Arrow(id, player);
                return;
            case 19:
                Case_Role(id, player, "Villageois", event);
                return;
            case 20:
                Case_Role(id, player, "Voyante", event);
                return;
            case 21:
                Case_Role(id, player, "Sorciere", event);
                return;
            case 22:
                Case_Role(id, player, "Garde", event);
                return;
            case 23:
                Case_Role(id, player, "Cupidon", event);
                return;
            case 24:
                Case_Role(id, player, "Chasseur", event);
                return;
            case 25:
                Case_Role(id, player, "LoupGarou", event);
        }
    }

}
