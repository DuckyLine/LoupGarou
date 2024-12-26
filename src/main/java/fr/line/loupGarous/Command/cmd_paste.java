package fr.line.loupGarous.Command;

import fr.line.loupGarous.LoupGarous;
import fr.line.loupGarous.YAML.Schematic_YAML;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.List;

public class cmd_paste implements CommandExecutor
{

    public static void  Create_Map(String name, Integer x, Integer z)
    {
        List<List<String>> List_Block = (List<List<String>>) Schematic_YAML.Schematic_YAML.getList(name);
        List<String> List_Slide = List_Block.get(0);
        Integer slide = Integer.valueOf(List_Slide.get(0));

        Integer n_x = x - ((slide - 1) / 2);
        Integer n_z = z - ((slide - 1) / 2);
        Set_Block(List_Block, n_x, n_z);
    }

    private static void Set_Block(List<List<String>> List_Block, Integer x, Integer z) {
        Integer i = 1;
        Integer n_x;
        Integer n_y;
        Integer n_z;
        String blockDataString;

        while (i < List_Block.size()) {
            List<String> parts = List_Block.get(i);

            n_x = x + Integer.valueOf(parts.get(0));
            n_y = 80 + Integer.valueOf(parts.get(1));
            n_z = z + Integer.valueOf(parts.get(2));

            Material type = Material.valueOf(parts.get(3));

            if (parts.size() > 4)
                blockDataString = parts.get(4);
            else
                blockDataString = null;

            Block block = LoupGarous.plugin.getServer().getWorld("LoupGarou_Games").getBlockAt(n_x, n_y, n_z);
            block.setType(type);

            if (blockDataString != null) {
                BlockData blockData = Bukkit.createBlockData(blockDataString);
                block.setBlockData(blockData);
            }

            i++;
        }
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
    {
        if (msg.equalsIgnoreCase("paste"))
        {
//            if (args.length != 4)
//                return false;
            String name = args[0];
            Integer x = Integer.valueOf(args[1]);
            Integer z = Integer.valueOf(args[2]);
            List<List<String>> List_Block = (List<List<String>>) Schematic_YAML.Schematic_YAML.getList(name);
            Set_Block(List_Block, x, z);
        }
        return false;
    }

}
