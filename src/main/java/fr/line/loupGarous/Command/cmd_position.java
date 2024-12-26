package fr.line.loupGarous.Command;

import fr.line.loupGarous.Utils.Struct.Copy_Struct;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class cmd_position implements CommandExecutor
{

    public static Map<String, Copy_Struct> Map_Postion_1 = new HashMap<>();
    public static Map<String, Copy_Struct> Map_Postion_2 = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (msg.equalsIgnoreCase("position"))
        {
            Player player = (Player) sender;
            Location location = player.getLocation();
            Integer x = (int) location.getX();
            Integer z = (int) location.getZ();
            if (x <= 0)
                x -= 1;
            if (z <= 0)
                z -= 1;
            Copy_Struct position = new Copy_Struct(location.getWorld().getName(), x, (int) location.getY(), z);

            if (args[0].equalsIgnoreCase("1"))
            {
                Map_Postion_1.put(player.getName(), position);
                player.sendMessage("§a§lPostion 1 §aAjouté avec succès !\n§e" + "x = " + position.getCoord("x") + " y = " +
                        position.getCoord("y") + " z = " + position.getCoord("z"));
            }
            else if (args[0].equalsIgnoreCase("2"))
            {
                Map_Postion_2.put(player.getName(), position);
                player.sendMessage("§a§lPostion 1 §aAjouté avec succès !\n§e" + "x = " + position.getCoord("x") + " y = " +
                        position.getCoord("y") + " z = " + position.getCoord("z"));
            }
        }
        return false;
    }
}
