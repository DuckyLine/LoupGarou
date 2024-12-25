package fr.line.loupGarous;

import fr.line.loupGarous.Command.cmd_game;
import fr.line.loupGarous.Command.cmd_lg;
import fr.line.loupGarous.Command.cmd_test;
import fr.line.loupGarous.Command.cmd_testb;
import fr.line.loupGarous.Event.Inventory_Click;
import fr.line.loupGarous.Event.Inventory_Close;
import fr.line.loupGarous.Start.Role;
import fr.line.loupGarous.Utils.Start_Message;
import fr.line.loupGarous.Utils.Struct.Main_Struct;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class LoupGarous extends JavaPlugin implements Listener {

    public static List<Main_Struct> Game_List = new ArrayList<>();
    public static List<String> List_Lobby = new ArrayList<>();
    public static Map<String, Integer> Player_Page = new HashMap<>();
    public static List<String> List_Role = Arrays.asList("Villageois", "Voyante", "Sorciere", "Garde", "Cupidon", "Chasseur", "LoupGarou");

    @Override
    public void onEnable()
    {
        Start_Message.Start_Message();

        Role.Role();

        getCommand("test").setExecutor(new cmd_test());
        getCommand("testb").setExecutor(new cmd_testb());
        getCommand("lg").setExecutor(new cmd_lg());
        getCommand("game").setExecutor(new cmd_game());
        Bukkit.getPluginManager().registerEvents(new Inventory_Click(), this);
        Bukkit.getPluginManager().registerEvents(new Inventory_Close(), this);
    }

    @Override
    public void onDisable()
    {
    }
}
