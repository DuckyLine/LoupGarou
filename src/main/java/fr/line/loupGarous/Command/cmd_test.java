package fr.line.loupGarous.Command;

import fr.line.loupGarous.LoupGarous;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class cmd_test implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (msg.equalsIgnoreCase("test"))
        {
            Integer i = 0;

            while (i < LoupGarous.Game_List.size())
            {
                System.out.println("Partie: " + i);
                System.out.println("Host de la partie = " + LoupGarous.Game_List.get(i).getHost());
                System.out.println("Liste des joueurs = " + LoupGarous.Game_List.get(i).getJoueurs());
                System.out.println("X = " + LoupGarous.Game_List.get(i).getX() + " Z = " + LoupGarous.Game_List.get(i).getZ());
                System.out.println("State de la partie = " + LoupGarous.Game_List.get(i).getState());
                System.out.println("Nombre maximum de joueurs = " + LoupGarous.Game_List.get(i).getNb_Player());
                System.out.println("Villageois=" + LoupGarous.Game_List.get(i).getRole("Villageois" ) + "/Voyante="
                        + LoupGarous.Game_List.get(i).getRole("Voyante") + "/Sorcière="
                        + LoupGarous.Game_List.get(i).getRole("Sorciere") + "/Garde="
                        + LoupGarous.Game_List.get(i).getRole("Garde") + "/Cupidon="
                        + LoupGarous.Game_List.get(i).getRole("Cupidon") + "/Chasseur="
                        + LoupGarous.Game_List.get(i).getRole("Chasseur") + "/LoupGarou="
                        + LoupGarous.Game_List.get(i).getRole("LoupGarou") + "\n");
                i++;
            }
        }
        return false;
    }
}
