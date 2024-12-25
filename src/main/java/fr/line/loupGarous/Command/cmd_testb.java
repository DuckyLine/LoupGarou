package fr.line.loupGarous.Command;

import fr.line.loupGarous.LoupGarous;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class cmd_testb implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args)
    {
        if (msg.equalsIgnoreCase("testb"))
        {
            Integer n = Integer.valueOf(args[0]);

            while (n > 0)
            {
                if (n % 2 == 0)
                    LoupGarous.List_Lobby.add("P" + n);
                else
                    LoupGarous.List_Lobby.add("I" + n);
                n -= 1;
            }
        }
        return false;
    }

}
