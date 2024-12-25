package fr.line.loupGarous.Utils;

import fr.line.loupGarous.LoupGarous;
import fr.line.loupGarous.Utils.Struct.Main_Struct;

public class Nb_Role_Game
{

    public static Integer Nb_Role_Game(Integer id)
    {
        Main_Struct Party = LoupGarous.Game_List.get(id);
        Integer Count = 0;

        Count += Party.getRole("Villageois");
        Count += Party.getRole("Voyante");
        Count += Party.getRole("Sorciere");
        Count += Party.getRole("Garde");
        Count += Party.getRole("Cupidon");
        Count += Party.getRole("Chasseur");
        Count += Party.getRole("LoupGarou");
        return Count;
    }

}
