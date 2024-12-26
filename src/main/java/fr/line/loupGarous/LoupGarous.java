package fr.line.loupGarous;

import fr.line.loupGarous.Command.*;
import fr.line.loupGarous.Event.Inventory_Click;
import fr.line.loupGarous.Event.Inventory_Close;
import fr.line.loupGarous.Start.Role;
import fr.line.loupGarous.Utils.Start_Message;
import fr.line.loupGarous.Utils.Struct.Main_Struct;
import fr.line.loupGarous.World.WorldManager;
import fr.line.loupGarous.YAML.Schematic_YAML;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.*;

public final class LoupGarous extends JavaPlugin implements Listener {

    public static LoupGarous plugin;
    public static List<Main_Struct> Game_List = new ArrayList<>();
    public static List<String> List_Lobby = new ArrayList<>();
    public static Map<String, Integer> Player_Page = new HashMap<>();
    public static List<String> List_Role = Arrays.asList("Villageois", "Voyante", "Sorciere", "Garde", "Cupidon", "Chasseur", "LoupGarou");

    @Override
    public void onEnable()
    {
        Start_Message.Start_Message();

        Role.Role();
        plugin = this;

        // Gestion des fichiers de configuration YAML
        Schematic_YAML.Schematic_YAML(this);

        // Gestion des mondes
        if (!Bukkit.getWorlds().contains("LoupGarou_Games"))
            WorldManager.createEmptyWorld("LoupGarou_Games");

        // Gestion des commandes
        getCommand("position").setExecutor(new cmd_position());
        getCommand("paste").setExecutor(new cmd_paste());
        getCommand("copy").setExecutor(new cmd_copy());
        getCommand("test").setExecutor(new cmd_test());
        getCommand("testb").setExecutor(new cmd_testb());
        getCommand("lg").setExecutor(new cmd_lg());
        getCommand("game").setExecutor(new cmd_game());

        // Gestion des events
        Bukkit.getPluginManager().registerEvents(new Inventory_Click(), this);
        Bukkit.getPluginManager().registerEvents(new Inventory_Close(), this);

    }

    @Override
    public void onDisable()
    {
    }
}
