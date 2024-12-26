package fr.line.loupGarous.Command;

import fr.line.loupGarous.Utils.Struct.Copy_Struct;
import fr.line.loupGarous.YAML.Schematic_YAML;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class cmd_copy implements CommandExecutor
{

    public static Copy_Struct High_Position(Copy_Struct Position_1, Copy_Struct Position_2)
    {
        Integer X;
        Integer Y;
        Integer Z;

        if (Position_1.getCoord("x") < Position_2.getCoord("x"))
            X = Position_2.getCoord("x");
        else
            X = Position_1.getCoord("x");
        if (Position_1.getCoord("y") < Position_2.getCoord("y"))
            Y = Position_2.getCoord("y");
        else
            Y = Position_1.getCoord("y");
        if (Position_1.getCoord("z") < Position_2.getCoord("z"))
            Z = Position_2.getCoord("z");
        else
            Z = Position_1.getCoord("z");

        return new Copy_Struct(Position_1.getWorld(), X, Y, Z);
    }

    public static Copy_Struct Lower_Position(Copy_Struct Position_1, Copy_Struct Position_2)
    {
        Integer X;
        Integer Y;
        Integer Z;

        if (Position_1.getCoord("x") > Position_2.getCoord("x"))
            X = Position_2.getCoord("x");
        else
            X = Position_1.getCoord("x");
        if (Position_1.getCoord("y") > Position_2.getCoord("y"))
            Y = Position_2.getCoord("y");
        else
            Y = Position_1.getCoord("y");
        if (Position_1.getCoord("z") > Position_2.getCoord("z"))
            Z = Position_2.getCoord("z");
        else
            Z = Position_1.getCoord("z");

        return new Copy_Struct(Position_1.getWorld(), X, Y, Z);
    }

    private static void Save_Block(Block block, List<List<String>> List_Block, Integer x, Integer y, Integer z)
    {
        List<String> New_Node = new ArrayList<>();

        New_Node.add(String.valueOf(x));
        New_Node.add(String.valueOf(y));
        New_Node.add(String.valueOf(z));

        New_Node.add(String.valueOf(block.getType()));
        New_Node.add(block.getBlockData().getAsString());
        List_Block.add(New_Node);
    }

    private static void Exec_Copy(Copy_Struct Position_Lower, Copy_Struct Position_High, Player player, String name)
    {
        if (Position_High.getCoord("x") - Position_Lower.getCoord("x") % 2 == 0
                || Position_High.getCoord("z") - Position_Lower.getCoord("z") % 2 == 0)
        {
            player.sendMessage("§c§lErreur §cVotre map possède des côtés pair !");
            return;
        }
        if ((Position_High.getCoord("x") - Position_Lower.getCoord("x"))
                != (Position_High.getCoord("z") - Position_Lower.getCoord("z")))
        {
            player.sendMessage("§c§lErreur §cVotre map n'est pas carré !");
            return;
        }
        List<List<String>> List_Block = new ArrayList<>();
        List<String> slide = new ArrayList<>();
        Integer x_tmp = Position_Lower.getCoord("x");
        Integer z_tmp = Position_Lower.getCoord("z");
        Integer y = 0;

        slide.add(String.valueOf(Position_High.getCoord("x") - Position_Lower.getCoord("x")));
        List_Block.add(slide);

        while (Position_Lower.getCoord("y") <= Position_High.getCoord("y"))
        {
            Integer z = 0;
            while (Position_Lower.getCoord("z") <= Position_High.getCoord("z"))
            {
                Integer x = 0;
                while (Position_Lower.getCoord("x") <= Position_High.getCoord("x"))
                {
                    Block block = player.getWorld().getBlockAt(new Location(player.getWorld(), Position_Lower.getCoord("x"),
                            Position_Lower.getCoord("y"), Position_Lower.getCoord("z")));
                    if (block.getType() != Material.AIR)
                        Save_Block(block, List_Block, x, y, z);
                    Position_Lower.setCoord("x", Position_Lower.getCoord("x") + 1);
                    x++;
                }
                Position_Lower.setCoord("x", x_tmp);
                Position_Lower.setCoord("z", Position_Lower.getCoord("z") + 1);
                z++;
            }
            Position_Lower.setCoord("z", z_tmp);
            Position_Lower.setCoord("y", Position_Lower.getCoord("y") + 1);
            y++;
        }
        Schematic_YAML.Schematic_YAML.set(name, List_Block);
        Schematic_YAML.Schematic_YAML_Save();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
    {
        if (msg.equalsIgnoreCase("copy"))
        {
            Player player = (Player) sender;

            if (args.length < 1)
            {
                player.sendMessage("§c§lErreur §cVous devez inscrire un nom !");
                return false;
            }
            if (!cmd_position.Map_Postion_1.containsKey(player.getName()) || !cmd_position.Map_Postion_2.containsKey(player.getName()))
            {
                player.sendMessage("§c§lErreur §cVous n'avez pas de région inscrite !");
                return false;
            }
            Exec_Copy(Lower_Position(cmd_position.Map_Postion_1.get(player.getName()), cmd_position.Map_Postion_2.get(player.getName())),
                    High_Position(cmd_position.Map_Postion_1.get(player.getName()), cmd_position.Map_Postion_2.get(player.getName())),
                    player, args[0]);
        }
        return false;
    }

}
