package fr.line.loupGarous.YAML;

import fr.line.loupGarous.LoupGarous;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Schematic_YAML
{

    public static FileConfiguration Schematic_YAML;

    public static void Schematic_YAML(LoupGarous plugin)
    {
        File FileSchematicConfig = new File(plugin.getDataFolder() + File.separator + "Schematic", "Schematic.yml");
        if (!FileSchematicConfig.exists())
        {
            FileSchematicConfig.getParentFile().mkdirs();
            plugin.saveResource("Schematic/Schematic.yml", false);
        }
        Schematic_YAML = YamlConfiguration.loadConfiguration(FileSchematicConfig);
    }

    public static void Schematic_YAML_Save()
    {
        try
        {
            Schematic_YAML.save(new File("plugins/LoupGarous/Schematic/Schematic.yml"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Une erreur s'est produite lors de la sauvegarde du fichier Schematic.yml.");
        }
    }

}
